internal class Solution {
  fun maxProfit(prices: IntArray): Int {
    // 第一次买入，第一次卖出，第二次买入，第二次卖出
    var f1 = -prices[0]
    var f2 = 0
    var f3 = -prices[0]
    var f4 = 0
    for (i in 1 until prices.size) {
      f1 = max(f1, -prices[i])
      f2 = max(f2, f1 + prices[i])
      f3 = max(f3, f2 - prices[i])
      f4 = max(f4, f3 + prices[i])
    }
    return f4
  }
}
