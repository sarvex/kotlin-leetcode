internal class Solution {
  fun numDistinct(s: String, t: String): Int {
    val m = s.length
    val n = t.length
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m + 1) {
      f[i][0] = 1
    }
    for (i in 1 until m + 1) {
      for (j in 1 until n + 1) {
        f[i][j] = f[i - 1][j]
        if (s[i - 1] == t[j - 1]) {
          f[i][j] += f[i - 1][j - 1]
        }
      }
    }
    return f[m][n]
  }
}
