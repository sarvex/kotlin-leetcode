internal class Solution {
  fun maximumLengthSubstring(s: String): Int {
    val cnt = IntArray(26)
    var ans = 0
    var i = 0
    var j = 0
    while (j < s.length) {
      val idx: Int = s[j].code - 'a'.code
      ++cnt[idx]
      while (cnt[idx] > 2) {
        --cnt[s[i++].code - 'a'.code]
      }
      ans = max(ans, j - i + 1)
      ++j
    }
    return ans
  }
}
