internal class Solution {
  fun removeDigit(number: String, digit: Char): String {
    var ans = "0"
    var i = 0
    val n = number.length
    while (i < n) {
      val d = number[i]
      if (d == digit) {
        val t: String = number.substring(0, i) + number.substring(i + 1)
        if (ans.compareTo(t) < 0) {
          ans = t
        }
      }
      ++i
    }
    return ans
  }
}
