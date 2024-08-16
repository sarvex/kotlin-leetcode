internal class Solution {
  fun orArray(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n - 1)
    for (i in 0 until n - 1) {
      ans[i] = nums[i] or nums[i + 1]
    }
    return ans
  }
}
