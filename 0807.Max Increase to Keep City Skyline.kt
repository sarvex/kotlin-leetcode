internal class Solution {
  fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val rowMax = IntArray(m)
    val colMax = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        rowMax[i] = max(rowMax[i], grid[i][j])
        colMax[j] = max(colMax[j], grid[i][j])
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans += min(rowMax[i], colMax[j]) - grid[i][j]
      }
    }
    return ans
  }
}
