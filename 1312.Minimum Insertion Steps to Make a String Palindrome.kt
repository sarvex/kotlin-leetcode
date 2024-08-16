internal class Solution {
  private var f: Array<Array<Int>>
  private var s: String? = null

  fun minInsertions(s: String): Int {
    this.s = s
    val n = s.length
    f = Array(n) { arrayOfNulls(n) }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 1 shl 30
    ans = if (s!![i] == s!![j]) {
      dfs(i + 1, j - 1)
    } else {
      min(dfs(i + 1, j), dfs(i, j - 1)) + 1
    }
    return ans.also { f[i][j] = it }
  }
}
