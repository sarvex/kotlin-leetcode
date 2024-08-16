internal class Solution {
  fun surfaceArea(grid: Array<IntArray>): Int {
    val n = grid.size
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          ans += 2 + grid[i][j] * 4
          if (i > 0) {
            ans -= min(grid[i][j], grid[i - 1][j]) * 2
          }
          if (j > 0) {
            ans -= min(grid[i][j], grid[i][j - 1]) * 2
          }
        }
      }
    }
    return ans
  }
}
