internal class Solution {
  fun numberOfSubmatrices(grid: Array<CharArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val s = Array(m + 1) { Array(n + 1) { IntArray(2) } }
    var ans = 0
    for (i in 1..m) {
      for (j in 1..n) {
        s[i][j][0] = (s[i - 1][j][0] + s[i][j - 1][0] - s[i - 1][j - 1][0]
            + (if (grid[i - 1][j - 1] == 'X') 1 else 0))
        s[i][j][1] = (s[i - 1][j][1] + s[i][j - 1][1] - s[i - 1][j - 1][1]
            + (if (grid[i - 1][j - 1] == 'Y') 1 else 0))
        if (s[i][j][0] > 0 && s[i][j][0] == s[i][j][1]) {
          ++ans
        }
      }
    }
    return ans
  }
}
