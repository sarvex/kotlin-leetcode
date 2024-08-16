internal class Solution {
  fun maxScore(s: String): Int {
    var ans = 0
    for (i in 1 until s.length) {
      var t = 0
      for (j in 0 until i) {
        if (s[j] == '0') {
          ++t
        }
      }
      for (j in i until s.length) {
        if (s[j] == '1') {
          ++t
        }
      }
      ans = max(ans, t)
    }
    return ans
  }
}
