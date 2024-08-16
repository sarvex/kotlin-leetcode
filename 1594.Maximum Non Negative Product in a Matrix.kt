internal class Solution {
  fun maxProductPath(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { Array(n) { LongArray(2) } }
    dp[0][0][0] = grid[0][0].toLong()
    dp[0][0][1] = grid[0][0].toLong()
    for (i in 1 until m) {
      dp[i][0][0] = dp[i - 1][0][0] * grid[i][0]
      dp[i][0][1] = dp[i - 1][0][1] * grid[i][0]
    }
    for (j in 1 until n) {
      dp[0][j][0] = dp[0][j - 1][0] * grid[0][j]
      dp[0][j][1] = dp[0][j - 1][1] * grid[0][j]
    }
    for (i in 1 until m) {
      for (j in 1 until n) {
        val v = grid[i][j]
        if (v >= 0) {
          dp[i][j][0] = min(dp[i - 1][j][0], dp[i][j - 1][0]) * v
          dp[i][j][1] = max(dp[i - 1][j][1], dp[i][j - 1][1]) * v
        } else {
          dp[i][j][0] = max(dp[i - 1][j][1], dp[i][j - 1][1]) * v
          dp[i][j][1] = min(dp[i - 1][j][0], dp[i][j - 1][0]) * v
        }
      }
    }
    val ans = dp[m - 1][n - 1][1]
    return if (ans < 0) -1 else (ans % Solution.Companion.MOD).toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
