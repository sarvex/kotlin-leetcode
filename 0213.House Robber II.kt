internal class Solution {
  fun rob(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) {
      return nums[0]
    }
    return max(rob(nums, 0, n - 2), rob(nums, 1, n - 1))
  }

  private fun rob(nums: IntArray, l: Int, r: Int): Int {
    var l = l
    var f = 0
    var g = 0
    while (l <= r) {
      val ff: Int = max(f, g)
      g = f + nums[l]
      f = ff
      ++l
    }
    return max(f, g)
  }
}
