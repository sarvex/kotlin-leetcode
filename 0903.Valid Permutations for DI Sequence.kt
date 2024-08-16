internal class Solution {
  fun numPermsDISequence(s: String): Int {
    val mod = 1e9.toInt() + 7
    val n = s.length
    val f = Array(n + 1) { IntArray(n + 1) }
    f[0][0] = 1
    for (i in 1..n) {
      if (s[i - 1] == 'D') {
        for (j in 0..i) {
          for (k in j until i) {
            f[i][j] = (f[i][j] + f[i - 1][k]) % mod
          }
        }
      } else {
        for (j in 0..i) {
          for (k in 0 until j) {
            f[i][j] = (f[i][j] + f[i - 1][k]) % mod
          }
        }
      }
    }
    var ans = 0
    for (j in 0..n) {
      ans = (ans + f[n][j]) % mod
    }
    return ans
  }
}
