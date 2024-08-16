internal class Solution {
  fun isPowerOfThree(n: Int): Boolean {
    var n = n
    while (n > 2) {
      if (n % 3 != 0) {
        return false
      }
      n /= 3
    }
    return n == 1
  }
}
