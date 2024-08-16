internal class Solution {
  fun minTimeToType(word: String): Int {
    var ans = 0
    var prev = 0
    for (c in word.toCharArray()) {
      val curr: Int = c.code - 'a'.code
      var t: Int = abs(prev - curr)
      t = min(t, 26 - t)
      ans += t + 1
      prev = curr
    }
    return ans
  }
}
