internal class Solution {
  fun maxAlternatingSum(nums: IntArray): Long {
    val n = nums.size
    val f = LongArray(n + 1)
    val g = LongArray(n + 1)
    for (i in 1..n) {
      f[i] = max(g[i - 1] - nums[i - 1], f[i - 1])
      g[i] = max(f[i - 1] + nums[i - 1], g[i - 1])
    }
    return max(f[n], g[n])
  }
}
