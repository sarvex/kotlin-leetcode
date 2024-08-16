internal class Solution {
  fun longestSubarray(nums: IntArray): Int {
    val n = nums.size
    val left = IntArray(n + 1)
    val right = IntArray(n + 1)
    for (i in 1..n) {
      if (nums[i - 1] == 1) {
        left[i] = left[i - 1] + 1
      }
    }
    for (i in n - 1 downTo 0) {
      if (nums[i] == 1) {
        right[i] = right[i + 1] + 1
      }
    }
    var ans = 0
    for (i in 0 until n) {
      ans = max(ans, left[i] + right[i + 1])
    }
    return ans
  }
}
