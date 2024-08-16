internal class Solution {
  fun mySqrt(x: Int): Int {
    var l = 0
    var r = x
    while (l < r) {
      val mid = (l + r + 1) ushr 1
      if (mid > x / mid) {
        r = mid - 1
      } else {
        l = mid
      }
    }
    return l
  }
}
