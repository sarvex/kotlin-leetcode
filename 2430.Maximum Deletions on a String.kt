internal class Solution {
  private var n = 0
  private var f: Array<Int>
  private var g: Array<IntArray>

  fun deleteString(s: String): Int {
    n = s.length
    f = arrayOfNulls(n)
    g = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          g[i][j] = g[i + 1][j + 1] + 1
        }
      }
    }
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i == n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    f[i] = 1
    for (j in 1..((n - i) / 2)) {
      if (g[i][i + j] >= j) {
        f[i] = max(f[i], 1 + dfs(i + j))
      }
    }
    return f[i]
  }
}
