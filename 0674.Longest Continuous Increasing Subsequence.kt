internal class Solution {
  fun findLengthOfLCIS(nums: IntArray): Int {
    var ans = 1
    var i = 1
    var cnt = 1
    while (i < nums.size) {
      if (nums[i - 1] < nums[i]) {
        ans = max(ans, ++cnt)
      } else {
        cnt = 1
      }
      ++i
    }
    return ans
  }
}
