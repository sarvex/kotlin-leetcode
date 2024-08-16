internal class Solution {
  fun findTheLongestBalancedSubstring(s: String): Int {
    val n = s.length
    var ans = 0
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (check(s, i, j)) {
          ans = max(ans, j - i + 1)
        }
      }
    }
    return ans
  }

  private fun check(s: String, i: Int, j: Int): Boolean {
    var cnt = 0
    for (k in i..j) {
      if (s[k] == '1') {
        ++cnt
      } else if (cnt > 0) {
        return false
      }
    }
    return cnt * 2 == j - i + 1
  }
}
