internal class Solution {
  fun maxProduct(nums: IntArray): Int {
    var f = nums[0]
    var g = nums[0]
    var ans = nums[0]
    for (i in 1 until nums.size) {
      val ff = f
      val gg = g
      f = max(nums[i], max(ff * nums[i], gg * nums[i]))
      g = min(nums[i], min(ff * nums[i], gg * nums[i]))
      ans = max(ans, f)
    }
    return ans
  }
}
