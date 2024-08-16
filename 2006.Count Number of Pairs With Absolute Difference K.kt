internal class Solution {
  fun countKDifference(nums: IntArray, k: Int): Int {
    var ans = 0
    var i = 0
    val n = nums.size
    while (i < n) {
      for (j in i + 1 until n) {
        if (abs(nums[i] - nums[j]) == k) {
          ++ans
        }
      }
      ++i
    }
    return ans
  }
}
