internal class Solution {
  fun minimumCoins(prices: IntArray): Int {
    val n = prices.size
    val q: Deque<Int> = ArrayDeque()
    for (i in n downTo 1) {
      while (!q.isEmpty() && q.peek() > i * 2 + 1) {
        q.poll()
      }
      if (i <= (n - 1) / 2) {
        prices[i - 1] += prices[q.peek() - 1]
      }
      while (!q.isEmpty() && prices[q.peekLast() - 1] >= prices[i - 1]) {
        q.pollLast()
      }
      q.offer(i)
    }
    return prices[0]
  }
}
