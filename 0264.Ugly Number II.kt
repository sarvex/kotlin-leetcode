internal class Solution {
  fun nthUglyNumber(n: Int): Int {
    var n = n
    val vis: Set<Long> = HashSet()
    val q: PriorityQueue<Long> = PriorityQueue()
    val f = intArrayOf(2, 3, 5)
    q.offer(1L)
    vis.add(1L)
    var ans: Long = 0
    while (n-- > 0) {
      ans = q.poll()
      for (v in f) {
        val next = ans * v
        if (vis.add(next)) {
          q.offer(next)
        }
      }
    }
    return ans.toInt()
  }
}
