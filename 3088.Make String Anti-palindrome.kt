import java.util.*

internal class Solution {
  fun makeAntiPalindrome(s: String): String {
    val cs: CharArray = s.toCharArray()
    Arrays.sort(cs)
    val n = cs.size
    val m = n / 2
    if (cs[m] == cs[m - 1]) {
      var i = m
      while (i < n && cs[i] == cs[i - 1]) {
        ++i
      }
      var j = m
      while (j < n && cs[j] == cs[n - j - 1]) {
        if (i >= n) {
          return "-1"
        }
        val t = cs[i]
        cs[i] = cs[j]
        cs[j] = t
        ++i
        ++j
      }
    }
    return String(cs)
  }
}
