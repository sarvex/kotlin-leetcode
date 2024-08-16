internal class Solution {
  fun differenceOfSum(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (x in nums) {
      var x = x
      a += x
      while (x > 0) {
        b += x % 10
        x /= 10
      }
    }
    return abs(a - b)
  }
}
