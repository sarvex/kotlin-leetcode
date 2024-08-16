internal class Solution {
  private var f: Array<Array<Boolean>>
  private var s: CharArray
  private var p: CharArray
  private var m = 0
  private var n = 0

  fun isMatch(s: String, p: String): Boolean {
    this.s = s.toCharArray()
    this.p = p.toCharArray()
    m = s.length
    n = p.length
    f = Array(m) { arrayOfNulls(n) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (i >= m) {
      return j >= n || (p[j] == '*' && dfs(i, j + 1))
    }
    if (j >= n) {
      return false
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    if (p[j] == '*') {
      f[i][j] = dfs(i + 1, j) || dfs(i + 1, j + 1) || dfs(i, j + 1)
    } else {
      f[i][j] = (p[j] == '?' || s[i] == p[j]) && dfs(i + 1, j + 1)
    }
    return f[i][j]
  }
}
