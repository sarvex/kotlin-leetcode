internal class Solution {
  fun canJump(nums: IntArray): Boolean {
    var mx = 0
    for (i in nums.indices) {
      if (mx < i) {
        return false
      }
      mx = max(mx, i + nums[i])
    }
    return true
  }
}
