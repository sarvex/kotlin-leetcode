internal class Solution {
  fun longestConsecutive(nums: IntArray): Int {
    val n = nums.size
    if (n < 2) {
      return n
    }
    Arrays.sort(nums)
    var ans = 1
    var t = 1
    for (i in 1 until n) {
      if (nums[i] == nums[i - 1]) {
        continue
      }
      if (nums[i] == nums[i - 1] + 1) {
        ans = max(ans, ++t)
      } else {
        t = 1
      }
    }
    return ans
  }
}
