internal class Solution {
  fun isPerfectSquare(num: Int): Boolean {
    var l = 1
    var r = num
    while (l < r) {
      val mid = (l + r) ushr 1
      if (1L * mid * mid >= num) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l * l == num
  }
}
