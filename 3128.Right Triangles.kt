internal class Solution {
  fun numberOfRightTriangles(grid: Array<IntArray>): Long {
    val m = grid.size
    val n = grid[0].size
    val rows = IntArray(m)
    val cols = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        rows[i] += grid[i][j]
        cols[j] += grid[i][j]
      }
    }
    var ans: Long = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          ans += ((rows[i] - 1) * (cols[j] - 1)).toLong()
        }
      }
    }
    return ans
  }
}
