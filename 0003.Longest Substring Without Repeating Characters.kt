internal class Solution {
  fun lengthOfLongestSubstring(s: String): Int {
    val ss = BooleanArray(128)
    var ans = 0
    var i = 0
    var j = 0
    while (j < s.length) {
      val c = s[j]
      while (ss[c.code]) {
        ss[s[i++].code] = false
      }
      ss[c.code] = true
      ans = max(ans, j - i + 1)
      ++j
    }
    return ans
  }
}
