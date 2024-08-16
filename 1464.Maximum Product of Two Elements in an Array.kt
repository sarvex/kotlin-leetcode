internal class Solution {
  fun maxProduct(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        ans = max(ans, (nums[i] - 1) * (nums[j] - 1))
      }
    }
    return ans
  }
}
