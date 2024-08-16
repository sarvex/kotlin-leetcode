import java.util.*

internal class Solution {
  fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
    val g: Array<List<IntArray>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val m = edges.size
    for (i in 0 until m) {
      val a = edges[i][0]
      val b = edges[i][1]
      val w = edges[i][2]
      g[a].add(intArrayOf(b, w, i))
      g[b].add(intArrayOf(a, w, i))
    }
    val dist = IntArray(n)
    val inf = 1 shl 30
    Arrays.fill(dist, inf)
    dist[0] = 0
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    pq.offer(intArrayOf(0, 0))
    while (!pq.isEmpty()) {
      val p: Unit = pq.poll()
      val da: Int = p.get(0)
      val a: Int = p.get(1)
      if (da > dist[a]) {
        continue
      }
      for (e in g[a]) {
        val b = e[0]
        val w = e[1]
        if (dist[b] > dist[a] + w) {
          dist[b] = dist[a] + w
          pq.offer(intArrayOf(dist[b], b))
        }
      }
    }
    val ans = BooleanArray(m)
    if (dist[n - 1] == inf) {
      return ans
    }
    val q: Deque<Int> = ArrayDeque()
    q.offer(n - 1)
    while (!q.isEmpty()) {
      val a: Int = q.poll()
      for (e in g[a]) {
        val b = e[0]
        val w = e[1]
        val i = e[2]
        if (dist[a] == dist[b] + w) {
          ans[i] = true
          q.offer(b)
        }
      }
    }
    return ans
  }
}
