internal class Solution {
  fun minDifference(nums: IntArray): Int {
    val n = nums.size
    if (n < 5) {
      return 0
    }
    Arrays.sort(nums)
    var ans = 1L shl 60
    for (l in 0..3) {
      val r = 3 - l
      ans = min(ans, nums[n - 1 - r].toLong() - nums[l])
    }
    return ans.toInt()
  }
}
