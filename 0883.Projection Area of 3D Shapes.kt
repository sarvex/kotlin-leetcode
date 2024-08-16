internal class Solution {
  fun projectionArea(grid: Array<IntArray>): Int {
    var xy = 0
    var yz = 0
    var zx = 0
    var i = 0
    val n = grid.size
    while (i < n) {
      var maxYz = 0
      var maxZx = 0
      for (j in 0 until n) {
        if (grid[i][j] > 0) {
          ++xy
        }
        maxYz = max(maxYz, grid[i][j])
        maxZx = max(maxZx, grid[j][i])
      }
      yz += maxYz
      zx += maxZx
      ++i
    }
    return xy + yz + zx
  }
}
