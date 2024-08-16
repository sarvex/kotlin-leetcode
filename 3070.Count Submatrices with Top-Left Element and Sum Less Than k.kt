internal class Solution {
  fun countSubmatrices(grid: Array<IntArray>, k: Int): Int {
    val m = grid.size
    val n = grid[0].size
    val s = Array(m + 1) { IntArray(n + 1) }
    var ans = 0
    for (i in 1..m) {
      for (j in 1..n) {
        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1]
        if (s[i][j] <= k) {
          ++ans
        }
      }
    }
    return ans
  }
}
