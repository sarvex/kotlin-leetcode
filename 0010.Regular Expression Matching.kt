internal class Solution {
  private var f: Array<Array<Boolean>>
  private var s: String? = null
  private var p: String? = null
  private var m = 0
  private var n = 0

  fun isMatch(s: String, p: String): Boolean {
    m = s.length
    n = p.length
    f = Array(m + 1) { arrayOfNulls(n + 1) }
    this.s = s
    this.p = p
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (j >= n) {
      return i == m
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var res = false
    res = if (j + 1 < n && p!![j + 1] == '*') {
      (dfs(i, j + 2)
          || (i < m && (s!![i] == p!![j] || p!![j] == '.') && dfs(i + 1, j)))
    } else {
      i < m && (s!![i] == p!![j] || p!![j] == '.') && dfs(i + 1, j + 1)
    }
    return res.also { f[i][j] = it }
  }
}
