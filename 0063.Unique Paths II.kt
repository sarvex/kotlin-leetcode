internal class Solution {
  private var f: Array<Array<Int>>
  private var obstacleGrid: Array<IntArray>
  private var m = 0
  private var n = 0

  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    m = obstacleGrid.size
    n = obstacleGrid[0].size
    this.obstacleGrid = obstacleGrid
    f = Array(m) { arrayOfNulls(n) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= m || j >= n || obstacleGrid[i][j] == 1) {
      return 0
    }
    if (i == m - 1 && j == n - 1) {
      return 1
    }
    if (f[i][j] == null) {
      f[i][j] = dfs(i + 1, j) + dfs(i, j + 1)
    }
    return f[i][j]
  }
}
