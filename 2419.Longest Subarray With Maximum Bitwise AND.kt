internal class Solution {
  fun longestSubarray(nums: IntArray): Int {
    var mx = 0
    for (v in nums) {
      mx = max(mx, v)
    }
    var ans = 0
    var cnt = 0
    for (v in nums) {
      if (v == mx) {
        ++cnt
        ans = max(ans, cnt)
      } else {
        cnt = 0
      }
    }
    return ans
  }
}
