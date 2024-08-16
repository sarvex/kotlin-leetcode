internal class Solution {
  fun canSortArray(nums: IntArray): Boolean {
    var preMx = 0
    var i = 0
    val n = nums.size
    while (i < n) {
      val cnt = Integer.bitCount(nums[i])
      var j = i + 1
      var mi = nums[i]
      var mx = nums[i]
      while (j < n && Integer.bitCount(nums[j]) == cnt) {
        mi = min(mi, nums[j])
        mx = max(mx, nums[j])
        j++
      }
      if (preMx > mi) {
        return false
      }
      preMx = mx
      i = j
    }
    return true
  }
}
