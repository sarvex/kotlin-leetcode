internal class Solution {
  fun longestSemiRepetitiveSubstring(s: String): Int {
    var ans = 1
    val n = s.length
    var i = 1
    var j = 0
    var cnt = 0
    while (i < n) {
      cnt += if (s[i] == s[i - 1]) 1 else 0
      while (cnt > 1) {
        cnt -= if (s[j] == s[j + 1]) 1 else 0
        ++j
      }
      ans = max(ans, i - j + 1)
      ++i
    }
    return ans
  }
}
