internal class Solution {
  fun scoreOfString(s: String): Int {
    var ans = 0
    for (i in 1 until s.length) {
      ans += abs(s[i - 1].code - s[i].code)
    }
    return ans
  }
}
