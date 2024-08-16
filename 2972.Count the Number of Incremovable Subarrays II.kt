internal class Solution {
  fun incremovableSubarrayCount(nums: IntArray): Long {
    var i = 0
    val n = nums.size
    while (i + 1 < n && nums[i] < nums[i + 1]) {
      ++i
    }
    if (i == n - 1) {
      return n * (n + 1L) / 2
    }
    var ans = (i + 2).toLong()
    for (j in n - 1 downTo 1) {
      while (i >= 0 && nums[i] >= nums[j]) {
        --i
      }
      ans += (i + 2).toLong()
      if (nums[j - 1] >= nums[j]) {
        break
      }
    }
    return ans
  }
}
