internal class Solution {
  fun minFlips(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var cnt1 = 0
    var cnt2 = 0
    for (row in grid) {
      for (j in 0 until n / 2) {
        if (row[j] != row[n - j - 1]) {
          ++cnt1
        }
      }
    }
    for (j in 0 until n) {
      for (i in 0 until m / 2) {
        if (grid[i][j] != grid[m - i - 1][j]) {
          ++cnt2
        }
      }
    }
    return min(cnt1, cnt2)
  }
}
