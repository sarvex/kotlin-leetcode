internal class Solution {
  fun minimumPushes(word: String): Int {
    val n = word.length
    var ans = 0
    var k = 1
    for (i in 0 until n / 8) {
      ans += k * 8
      ++k
    }
    ans += k * (n % 8)
    return ans
  }
}
