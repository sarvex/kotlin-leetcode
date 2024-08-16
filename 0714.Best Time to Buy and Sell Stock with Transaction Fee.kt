internal class Solution {
  private var f: Array<Array<Int>>
  private var prices: IntArray
  private var fee = 0

  fun maxProfit(prices: IntArray, fee: Int): Int {
    f = Array(prices.size) { arrayOfNulls(2) }
    this.prices = prices
    this.fee = fee
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
      ans = max(ans, prices[i] + dfs(i + 1, 0) - fee)
    } else {
      ans = max(ans, -prices[i] + dfs(i + 1, 1))
    }
    return ans.also { f[i][j] = it }
  }
}
