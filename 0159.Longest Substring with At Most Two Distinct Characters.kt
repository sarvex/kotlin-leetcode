internal class Solution {
  fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    val cnt: Map<Char, Int> = HashMap()
    val n = s.length
    var ans = 0
    var i = 0
    var j = 0
    while (i < n) {
      val c = s[i]
      cnt.put(c, cnt.getOrDefault(c, 0) + 1)
      while (cnt.size() > 2) {
        val t = s[j++]
        cnt.put(t, cnt[t]!! - 1)
        if (cnt[t] === 0) {
          cnt.remove(t)
        }
      }
      ans = max(ans, i - j + 1)
      ++i
    }
    return ans
  }
}
