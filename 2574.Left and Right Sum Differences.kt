import java.util.*

internal class Solution {
  fun leftRigthDifference(nums: IntArray): IntArray {
    var left = 0
    var right = Arrays.stream(nums).sum()
    val n = nums.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      right -= nums[i]
      ans[i] = abs(left - right)
      left += nums[i]
    }
    return ans
  }
}
