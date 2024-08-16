internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private var grid: Array<IntArray>
  private var m = 0
  private var n = 0

  fun getMaximumGold(grid: Array<IntArray>): Int {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans = max(ans, dfs(i, j))
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
      return 0
    }
    val v = grid[i][j]
    grid[i][j] = 0
    var ans = 0
    for (k in 0..3) {
      ans = max(ans, v + dfs(i + dirs[k], j + dirs[k + 1]))
    }
    grid[i][j] = v
    return ans
  }
}
