internal class Solution {
  fun maximumOddBinaryNumber(s: String): String {
    val cnt: Int = s.length - s.replace("1", "").length
    return "1".repeat(cnt - 1) + "0".repeat(s.length - cnt) + "1"
  }
}
