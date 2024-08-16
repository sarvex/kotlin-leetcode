internal class Solution {
  private val mod = 1e9.toInt() + 7
  private var f: Array<Array<Array<Long>>>
  private var limit = 0

  fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
    f = Array(zero + 1) { Array(one + 1) { arrayOfNulls(2) } }
    this.limit = limit
    return ((dfs(zero, one, 0) + dfs(zero, one, 1)) % mod).toInt()
  }

  private fun dfs(i: Int, j: Int, k: Int): Long {
    if (i < 0 || j < 0) {
      return 0
    }
    if (i == 0) {
      return if (k == 1 && j <= limit) 1 else 0
    }
    if (j == 0) {
      return if (k == 0 && i <= limit) 1 else 0
    }
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    if (k == 0) {
      f[i][j][k]
      = (dfs(i - 1, j, 0) + dfs(i - 1, j, 1) - dfs(i - limit - 1, j, 1) + mod) % mod
    } else {
      f[i][j][k]
      = (dfs(i, j - 1, 0) + dfs(i, j - 1, 1) - dfs(i, j - limit - 1, 0) + mod) % mod
    }
    return f[i][j][k]
  }
}
