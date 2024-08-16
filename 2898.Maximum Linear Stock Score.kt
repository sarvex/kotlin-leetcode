internal class Solution {
  fun maxScore(prices: IntArray): Long {
    val cnt: Map<Int, Long> = HashMap()
    for (i in prices.indices) {
      cnt.merge(prices[i] - i, prices[i].toLong()) { a: Long, b: Long -> java.lang.Long.sum(a, b) }
    }
    var ans: Long = 0
    for (v in cnt.values()) {
      ans = max(ans, v)
    }
    return ans
  }
}
