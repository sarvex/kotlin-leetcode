internal class Solution {
  fun possibleToStamp(grid: Array<IntArray>, stampHeight: Int, stampWidth: Int): Boolean {
    val m = grid.size
    val n = grid[0].size
    val s = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + grid[i - 1][j - 1]
      }
    }
    val d = Array(m + 2) { IntArray(n + 2) }
    run {
      var i = 1
      while (i + stampHeight - 1 <= m) {
        var j = 1
        while (j + stampWidth - 1 <= n) {
          val x = i + stampHeight - 1
          val y = j + stampWidth - 1
          if (s[x][y] - s[x][j - 1] - s[i - 1][y] + s[i - 1][j - 1] == 0) {
            d[i][j]++
            d[i][y + 1]--
            d[x + 1][j]--
            d[x + 1][y + 1]++
          }
          ++j
        }
        ++i
      }
    }
    for (i in 1..m) {
      for (j in 1..n) {
        d[i][j] += d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1]
        if (grid[i - 1][j - 1] == 0 && d[i][j] == 0) {
          return false
        }
      }
    }
    return true
  }
}
