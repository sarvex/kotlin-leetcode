internal class Solution {
  fun findClosestNumber(nums: IntArray): Int {
    var ans = 0
    var d = 1 shl 30
    for (x in nums) {
      val y: Int = abs(x)
      if (y < d || (y == d && x > ans)) {
        ans = x
        d = y
      }
    }
    return ans
  }
}
