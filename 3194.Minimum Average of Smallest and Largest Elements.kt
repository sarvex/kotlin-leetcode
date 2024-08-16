import java.util.*

internal class Solution {
  fun minimumAverage(nums: IntArray): Double {
    Arrays.sort(nums)
    val n = nums.size
    var ans = 1 shl 30
    for (i in 0 until n / 2) {
      ans = min(ans, nums[i] + nums[n - i - 1])
    }
    return ans / 2.0
  }
}
