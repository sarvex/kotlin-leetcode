internal class Solution {
  fun subArrayRanges(nums: IntArray): Long {
    var ans: Long = 0
    val n = nums.size
    for (i in 0 until n - 1) {
      var mi = nums[i]
      var mx = nums[i]
      for (j in i + 1 until n) {
        mi = min(mi, nums[j])
        mx = max(mx, nums[j])
        ans += (mx - mi).toLong()
      }
    }
    return ans
  }
}
