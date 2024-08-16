internal class Solution {
  fun minimumArea(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var x1 = m
    var y1 = n
    var x2 = 0
    var y2 = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          x1 = min(x1, i)
          y1 = min(y1, j)
          x2 = max(x2, i)
          y2 = max(y2, j)
        }
      }
    }
    return (x2 - x1 + 1) * (y2 - y1 + 1)
  }
}
