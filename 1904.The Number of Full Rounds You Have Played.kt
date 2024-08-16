internal class Solution {
  fun numberOfRounds(loginTime: String, logoutTime: String): Int {
    val a = f(loginTime)
    var b = f(logoutTime)
    if (a > b) {
      b += 1440
    }
    return max(0, b / 15 - (a + 14) / 15)
  }

  private fun f(s: String): Int {
    val h: Int = s.substring(0, 2).toInt()
    val m: Int = s.substring(3, 5).toInt()
    return h * 60 + m
  }
}
