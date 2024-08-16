internal class Solution {
  fun satisfiesConditions(grid: Array<IntArray>): Boolean {
    val m = grid.size
    val n = grid[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (i + 1 < m && grid[i][j] != grid[i + 1][j]) {
          return false
        }
        if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
          return false
        }
      }
    }
    return true
  }
}
