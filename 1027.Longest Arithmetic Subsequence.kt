internal class Solution {
  fun longestArithSeqLength(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    val f = Array(n) { IntArray(1001) }
    for (i in 1 until n) {
      for (k in 0 until i) {
        val j = nums[i] - nums[k] + 500
        f[i][j] = max(f[i][j], f[k][j] + 1)
        ans = max(ans, f[i][j])
      }
    }
    return ans + 1
  }
}
