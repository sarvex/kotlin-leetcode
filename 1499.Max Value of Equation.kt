internal class Solution {
  fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
    var ans = -(1 shl 30)
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> b.get(0) - a.get(0) }
    for (p in points) {
      val x = p[0]
      val y = p[1]
      while (!pq.isEmpty() && x - pq.peek().get(1) > k) {
        pq.poll()
      }
      if (!pq.isEmpty()) {
        ans = Math.max(ans, x + y + pq.peek().get(0))
      }
      pq.offer(intArrayOf(y - x, x))
    }
    return ans
  }
}
