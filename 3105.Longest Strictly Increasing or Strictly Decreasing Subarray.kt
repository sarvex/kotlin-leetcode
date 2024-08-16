internal class Solution {
  fun longestMonotonicSubarray(nums: IntArray): Int {
    var ans = 1
    run {
      var i = 1
      var t = 1
      while (i < nums.size) {
        if (nums[i - 1] < nums[i]) {
          ans = max(ans, ++t)
        } else {
          t = 1
        }
        ++i
      }
    }
    var i = 1
    var t = 1
    while (i < nums.size) {
      if (nums[i - 1] > nums[i]) {
        ans = max(ans, ++t)
      } else {
        t = 1
      }
      ++i
    }
    return ans
  }
}
