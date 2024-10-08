internal class Solution {
  fun reverse(x: Int): Int {
    var x = x
    var ans = 0
    while (x != 0) {
      if (ans < MIN_VALUE / 10 || ans > MAX_VALUE / 10) {
        return 0
      }
      ans = ans * 10 + x % 10
      x /= 10
    }
    return ans
  }
}
