internal class Solution {
  fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
    val dp = Array(n) { IntArray(n) }
    for (e in dp) {
      Arrays.fill(e, n)
    }
    for (e in mines) {
      dp[e[0]][e[1]] = 0
    }
    for (i in 0 until n) {
      var left = 0
      var right = 0
      var up = 0
      var down = 0
      var j = 0
      var k = n - 1
      while (j < n) {
        left = if (dp[i][j] > 0) left + 1 else 0
        right = if (dp[i][k] > 0) right + 1 else 0
        up = if (dp[j][i] > 0) up + 1 else 0
        down = if (dp[k][i] > 0) down + 1 else 0
        dp[i][j] = min(dp[i][j], left)
        dp[i][k] = min(dp[i][k], right)
        dp[j][i] = min(dp[j][i], up)
        dp[k][i] = min(dp[k][i], down)
        ++j
        --k
      }
    }
    return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt()
  }
}
