import java.util.*

internal class Solution {
  fun findValueOfPartition(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 1 shl 30
    for (i in 1 until nums.size) {
      ans = min(ans, nums[i] - nums[i - 1])
    }
    return ans
  }
}
