internal class Solution {
  fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    var ans = 0
    val n = nums.size
    for (l in 0 until n) {
      if (nums[l] % 2 == 0 && nums[l] <= threshold) {
        var r: Int = l + 1
        while (r < n && nums[r] % 2 != nums[r - 1] % 2 && nums[r] <= threshold) {
          ++r
        }
        ans = max(ans, r - l)
      }
    }
    return ans
  }
}
