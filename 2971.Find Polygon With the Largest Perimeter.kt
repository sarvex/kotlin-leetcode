import java.util.*

internal class Solution {
  fun largestPerimeter(nums: IntArray): Long {
    Arrays.sort(nums)
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + nums[i - 1]
    }
    var ans: Long = -1
    for (k in 3..n) {
      if (s[k - 1] > nums[k - 1]) {
        ans = max(ans, s[k])
      }
    }
    return ans
  }
}
