internal class Solution {
  fun maximumTop(nums: IntArray, k: Int): Int {
    if (k == 0) {
      return nums[0]
    }
    val n = nums.size
    if (n == 1) {
      if (k % 2 == 1) {
        return -1
      }
      return nums[0]
    }
    var ans = -1
    for (i in 0 until min(k - 1, n)) {
      ans = max(ans, nums[i])
    }
    if (k < n) {
      ans = max(ans, nums[k])
    }
    return ans
  }
}
