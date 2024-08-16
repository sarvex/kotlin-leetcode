internal class Solution {
  private val dirs = intArrayOf(-1, 0, 1, 0, -1)
  private var grid1: Array<IntArray>
  private var grid2: Array<IntArray>
  private var m = 0
  private var n = 0

  fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    m = grid1.size
    n = grid1[0].size
    this.grid1 = grid1
    this.grid2 = grid2
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid2[i][j] == 1) {
          ans += dfs(i, j)
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    var ok = grid1[i][j]
    grid2[i][j] = 0
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && grid2[x][y] == 1) {
        ok = ok and dfs(x, y)
      }
    }
    return ok
  }
}
