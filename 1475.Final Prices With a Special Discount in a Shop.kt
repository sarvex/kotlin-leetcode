internal class Solution {
  fun finalPrices(prices: IntArray): IntArray {
    val n = prices.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = prices[i]
      for (j in i + 1 until n) {
        if (prices[j] <= prices[i]) {
          ans[i] -= prices[j]
          break
        }
      }
    }
    return ans
  }
}
