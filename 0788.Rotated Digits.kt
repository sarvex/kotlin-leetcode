internal class Solution {
  private val d = intArrayOf(0, 1, 5, -1, -1, 2, 9, -1, 8, 6)

  fun rotatedDigits(n: Int): Int {
    var ans = 0
    for (i in 1..n) {
      if (check(i)) {
        ++ans
      }
    }
    return ans
  }

  private fun check(x: Int): Boolean {
    var y = 0
    var t = x
    var k = 1
    while (t > 0) {
      val v = t % 10
      if (d[v] == -1) {
        return false
      }
      y = d[v] * k + y
      k *= 10
      t /= 10
    }
    return x != y
  }
}
