import java.util.*

internal class Solution {
  fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
    Arrays.sort(nums)
    val n = nums.size
    val m = n shr 1
    var ans: Long = abs(nums[m] - k)
    if (nums[m] > k) {
      var i = m - 1
      while (i >= 0 && nums[i] > k) {
        ans += (nums[i] - k).toLong()
        --i
      }
    } else {
      var i = m + 1
      while (i < n && nums[i] < k) {
        ans += (k - nums[i]).toLong()
        ++i
      }
    }
    return ans
  }
}
