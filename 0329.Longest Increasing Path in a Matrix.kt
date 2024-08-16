internal class Solution {
  private var m = 0
  private var n = 0
  private var matrix: Array<IntArray>
  private var f: Array<IntArray>

  fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    m = matrix.size
    n = matrix[0].size
    f = Array(m) { IntArray(n) }
    this.matrix = matrix
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans = max(ans, dfs(i, j))
      }
    }
    return ans
  }

  private fun dfs(i: Int, j: Int): Int {
    if (f[i][j] != 0) {
      return f[i][j]
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
        f[i][j] = max(f[i][j], dfs(x, y))
      }
    }
    return ++f[i][j]
  }
}
