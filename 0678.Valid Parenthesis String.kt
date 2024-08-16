internal class Solution {
  fun checkValidString(s: String): Boolean {
    val n = s.length
    val dp = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
      dp[i][i] = s[i] == '*'
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        val a = s[i]
        val b = s[j]
        dp[i][j] = (a == '(' || a == '*') && (b == '*' || b == ')')
            && (i + 1 == j || dp[i + 1][j - 1])
        var k: Int = i
        while (k < j && !dp[i][j]) {
          dp[i][j] = dp[i][k] && dp[k + 1][j]
          ++k
        }
      }
    }
    return dp[0][n - 1]
  }
}
