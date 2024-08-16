internal class Solution {
  fun maxAbsoluteSum(nums: IntArray): Int {
    var f = 0
    var g = 0
    var ans = 0
    for (x in nums) {
      f = max(f, 0) + x
      g = min(g, 0) + x
      ans = max(ans, max(f, abs(g)))
    }
    return ans
  }
}
