internal class Solution {
  fun maxPower(s: String): Int {
    var ans = 1
    var t = 1
    for (i in 1 until s.length) {
      if (s[i] == s[i - 1]) {
        ans = max(ans, ++t)
      } else {
        t = 1
      }
    }
    return ans
  }
}
