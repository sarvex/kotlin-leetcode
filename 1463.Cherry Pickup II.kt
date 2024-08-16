internal class Solution {
  fun cherryPickup(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val f = Array(m) { Array(n) { IntArray(n) } }
    for (g in f) {
      for (h in g) {
        Arrays.fill(h, -1)
      }
    }
    f[0][0][n - 1] = grid[0][0] + grid[0][n - 1]
    for (i in 1 until m) {
      for (j1 in 0 until n) {
        for (j2 in 0 until n) {
          val x = grid[i][j1] + (if (j1 == j2) 0 else grid[i][j2])
          for (y1 in j1 - 1..(j1 + 1)) {
            for (y2 in j2 - 1..(j2 + 1)) {
              if (y1 >= 0 && y1 < n && y2 >= 0 && y2 < n && f[i - 1][y1][y2] != -1) {
                f[i][j1][j2] = max(f[i][j1][j2], f[i - 1][y1][y2] + x)
              }
            }
          }
        }
      }
    }
    var ans = 0
    for (j1 in 0 until n) {
      for (j2 in 0 until n) {
        ans = max(ans, f[m - 1][j1][j2])
      }
    }
    return ans
  }
}
