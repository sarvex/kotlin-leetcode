internal class Solution {
  fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {
    val q: Deque<Int> = ArrayDeque()
    val n = chargeTimes.size
    var s: Long = 0
    var j = 0
    var ans = 0
    for (i in 0 until n) {
      val a = chargeTimes[i]
      val b = runningCosts[i]
      while (!q.isEmpty() && chargeTimes[q.getLast()] <= a) {
        q.pollLast()
      }
      q.offer(i)
      s += b.toLong()
      while (!q.isEmpty() && chargeTimes[q.getFirst()] + (i - j + 1) * s > budget) {
        if (q.getFirst() === j) {
          q.pollFirst()
        }
        s -= runningCosts[j++].toLong()
      }
      ans = max(ans, i - j + 1)
    }
    return ans
  }
}
