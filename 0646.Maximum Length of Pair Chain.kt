internal class Solution {
  fun findLongestChain(pairs: Array<IntArray>): Int {
    Arrays.sort(pairs, Comparator.comparingInt { a -> a.get(0) })
    val n = pairs.size
    val dp = IntArray(n)
    var ans = 0
    for (i in 0 until n) {
      dp[i] = 1
      val c = pairs[i][0]
      for (j in 0 until i) {
        val b = pairs[j][1]
        if (b < c) {
          dp[i] = max(dp[i], dp[j] + 1)
        }
      }
      ans = max(ans, dp[i])
    }
    return ans
  }
}
