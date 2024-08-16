internal class Solution {
  fun maxEvents(events: Array<IntArray>): Int {
    val d: Map<Int, List<Int>> = HashMap()
    var i: Int = MAX_VALUE
    var j = 0
    for (v in events) {
      val s = v[0]
      val e = v[1]
      d.computeIfAbsent(s) { k -> ArrayList() }.add(e)
      i = min(i, s)
      j = max(j, e)
    }
    val q: PriorityQueue<Int> = PriorityQueue()
    var ans = 0
    for (s in i..j) {
      while (!q.isEmpty() && q.peek() < s) {
        q.poll()
      }
      for (e in d.getOrDefault(s, Collections.emptyList())) {
        q.offer(e)
      }
      if (!q.isEmpty()) {
        q.poll()
        ++ans
      }
    }
    return ans
  }
}
