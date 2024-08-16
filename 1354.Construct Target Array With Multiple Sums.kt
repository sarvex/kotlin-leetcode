internal class Solution {
  fun isPossible(target: IntArray): Boolean {
    val pq: PriorityQueue<Long> = PriorityQueue(Collections.reverseOrder())
    var s: Long = 0
    for (x in target) {
      s += x.toLong()
      pq.offer(x.toLong())
    }
    while (pq.peek() > 1) {
      val mx: Long = pq.poll()
      val t = s - mx
      if (t == 0L || mx - t < 1) {
        return false
      }
      var x = mx % t
      if (x == 0L) {
        x = t
      }
      pq.offer(x)
      s = s - mx + x
    }
    return true
  }
}
