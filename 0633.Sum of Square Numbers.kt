internal class Solution {
  fun judgeSquareSum(c: Int): Boolean {
    var a: Long = 0
    var b = sqrt(c) as Long
    while (a <= b) {
      val s = a * a + b * b
      if (s == c.toLong()) {
        return true
      }
      if (s < c) {
        ++a
      } else {
        --b
      }
    }
    return false
  }
}
