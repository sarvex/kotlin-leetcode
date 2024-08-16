internal class Solution {
  fun minFallingPathSum(grid: Array<IntArray>): Int {
    val n = grid.size
    val f = Array(n + 1) { IntArray(n) }
    val inf = 1 shl 30
    for (i in 1..n) {
      for (j in 0 until n) {
        var x = inf
        for (k in 0 until n) {
          if (k != j) {
            x = min(x, f[i - 1][k])
          }
        }
        f[i][j] = grid[i - 1][j] + (if (x == inf) 0 else x)
      }
    }
    var ans = inf
    for (x in f[n]) {
      ans = min(ans, x)
    }
    return ans
  }
}
