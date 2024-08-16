internal class Solution {
  private val mod = 1e9.toInt() + 7
  private var n = 0
  private var f: Array<Array<Array<Int>>>

  fun checkRecord(n: Int): Int {
    this.n = n
    f = Array(n) { Array(2) { arrayOfNulls(3) } }
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (i >= n) {
      return 1
    }
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    var ans = dfs(i + 1, j, 0)
    if (j == 0) {
      ans = (ans + dfs(i + 1, j + 1, 0)) % mod
    }
    if (k < 2) {
      ans = (ans + dfs(i + 1, j, k + 1)) % mod
    }
    return ans.also { f[i][j][k] = it }
  }
}
