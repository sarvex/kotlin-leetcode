internal class Solution {
  fun maxSubArray(nums: IntArray): Int {
    var ans = nums[0]
    var i = 1
    var f = nums[0]
    while (i < nums.size) {
      f = max(f, 0) + nums[i]
      ans = max(ans, f)
      ++i
    }
    return ans
  }
}
