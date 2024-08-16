internal class Solution {
  fun maxScore(grid: List<List<Int>>): Int {
    val m: Int = grid.size()
    val n: Int = grid[0].size()
    val inf = 1 shl 30
    var ans = -inf
    val f = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        var mi = inf
        if (i > 0) {
          mi = min(mi, f[i - 1][j])
        }
        if (j > 0) {
          mi = min(mi, f[i][j - 1])
        }
        ans = Math.max(ans, grid[i][j] - mi)
        f[i][j] = Math.min(grid[i][j], mi)
      }
    }
    return ans
  }
}
