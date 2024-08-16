internal class Solution {
  private var prices: IntArray
  private var f: IntArray
  private var n = 0

  fun minimumCoins(prices: IntArray): Int {
    n = prices.size
    f = IntArray(n + 1)
    this.prices = prices
    return dfs(1)
  }

  private fun dfs(i: Int): Int {
    if (i * 2 >= n) {
      return prices[i - 1]
    }
    if (f[i] == 0) {
      f[i] = 1 shl 30
      for (j in i + 1..(i * 2 + 1)) {
        f[i] = min(f[i], prices[i - 1] + dfs(j))
      }
    }
    return f[i]
  }
}
