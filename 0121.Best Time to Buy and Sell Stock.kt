internal class Solution {
  fun maxProfit(prices: IntArray): Int {
    var ans = 0
    var mi = prices[0]
    for (v in prices) {
      ans = max(ans, v - mi)
      mi = min(mi, v)
    }
    return ans
  }
}
