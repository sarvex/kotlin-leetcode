internal class Solution {
  fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    var ans = 0
    for (i in tickets.indices) {
      ans += min(tickets[i], if (i <= k) tickets[k] else tickets[k] - 1)
    }
    return ans
  }
}
