internal class Solution {
  fun lastStoneWeightII(stones: IntArray): Int {
    var s = 0
    for (v in stones) {
      s += v
    }
    val m = stones.size
    val n = s shr 1
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 0..n) {
        dp[i][j] = dp[i - 1][j]
        if (stones[i - 1] <= j) {
          dp[i][j] = max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1])
        }
      }
    }
    return s - dp[m][n] * 2
  }
}
