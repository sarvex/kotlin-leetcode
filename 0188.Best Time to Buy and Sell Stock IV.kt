internal class Solution {
  private var f: Array<Array<Array<Int>>>
  private var prices: IntArray
  private var n = 0

  fun maxProfit(k: Int, prices: IntArray): Int {
    n = prices.size
    this.prices = prices
    f = Array(n) { Array(k + 1) { arrayOfNulls(2) } }
    return dfs(0, k, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    var ans = dfs(i + 1, j, k)
    if (k > 0) {
      ans = max(ans, prices[i] + dfs(i + 1, j, 0))
    } else if (j > 0) {
      ans = max(ans, -prices[i] + dfs(i + 1, j - 1, 1))
    }
    return ans.also { f[i][j][k] = it }
  }
}
