internal class Solution {
  fun alternatingSubarray(nums: IntArray): Int {
    var ans = -1
    val n = nums.size
    for (i in 0 until n) {
      var k = 1
      var j: Int = i
      while (j + 1 < n && nums[j + 1] - nums[j] == k) {
        k *= -1
        ++j
      }
      if (j - i + 1 > 1) {
        ans = max(ans, j - i + 1)
      }
    }
    return ans
  }
}
