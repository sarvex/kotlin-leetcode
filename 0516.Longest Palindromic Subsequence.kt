internal class Solution {
  fun longestPalindromeSubseq(s: String): Int {
    val n = s.length
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = 1
    }
    for (i in n - 1 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          f[i][j] = f[i + 1][j - 1] + 2
        } else {
          f[i][j] = max(f[i + 1][j], f[i][j - 1])
        }
      }
    }
    return f[0][n - 1]
  }
}
