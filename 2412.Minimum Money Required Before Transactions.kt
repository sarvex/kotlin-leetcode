internal class Solution {
  fun minimumMoney(transactions: Array<IntArray>): Long {
    var s: Long = 0
    for (e in transactions) {
      s += max(0, e[0] - e[1])
    }
    var ans: Long = 0
    for (e in transactions) {
      if (e[0] > e[1]) {
        ans = max(ans, s + e[1])
      } else {
        ans = max(ans, s + e[0])
      }
    }
    return ans
  }
}
