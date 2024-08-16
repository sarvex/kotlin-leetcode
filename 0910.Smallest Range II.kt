internal class Solution {
  fun smallestRangeII(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    val n = nums.size
    var ans = nums[n - 1] - nums[0]
    for (i in 1 until n) {
      val mi: Int = min(nums[0] + k, nums[i] - k)
      val mx: Int = max(nums[i - 1] + k, nums[n - 1] - k)
      ans = min(ans, mx - mi)
    }
    return ans
  }
}
