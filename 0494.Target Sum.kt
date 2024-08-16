internal class Solution {
  fun findTargetSumWays(nums: IntArray, target: Int): Int {
    val s: Int = Arrays.stream(nums).sum()
    if (s < target || (s - target) % 2 != 0) {
      return 0
    }
    val m = nums.size
    val n = (s - target) / 2
    val f = Array(m + 1) { IntArray(n + 1) }
    f[0][0] = 1
    for (i in 1..m) {
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (j >= nums[i - 1]) {
          f[i][j] += f[i - 1][j - nums[i - 1]]
        }
      }
    }
    return f[m][n]
  }
}
