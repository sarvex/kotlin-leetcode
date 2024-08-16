internal class Solution {
  private var prices: IntArray
  private var f: Array<Array<Int>>

  fun maxProfit(prices: IntArray): Int {
    this.prices = prices
    f = Array(prices.size) { arrayOfNulls(2) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= prices.size) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = dfs(i + 1, j)
    if (j > 0) {
      ans = max(ans, prices[i] + dfs(i + 2, 0))
    } else {
      ans = max(ans, -prices[i] + dfs(i + 1, 1))
    }
    return ans.also { f[i][j] = it }
  }
}
