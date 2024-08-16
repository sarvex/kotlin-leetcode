internal class Solution {
  fun sumOfDigits(nums: IntArray): Int {
    var x = 100
    for (v in nums) {
      x = min(x, v)
    }
    var s = 0
    while (x > 0) {
      s += x % 10
      x /= 10
    }
    return s and 1 xor 1
  }
}
