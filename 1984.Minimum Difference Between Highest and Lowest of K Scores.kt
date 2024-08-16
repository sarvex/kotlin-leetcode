internal class Solution {
  fun minimumDifference(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = 100000
    for (i in 0 until nums.size - k + 1) {
      ans = min(ans, nums[i + k - 1] - nums[i])
    }
    return ans
  }
}
