import java.util.*

internal class Solution {
  fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
    val g: Array<List<IntArray>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val w = e[2]
      g[u].add(intArrayOf(v, w))
      g[v].add(intArrayOf(u, w))
    }
    val dist = IntArray(n)
    Arrays.fill(dist, 1 shl 30)
    dist[0] = 0
    val pq: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    pq.offer(intArrayOf(0, 0))
    while (!pq.isEmpty()) {
      val e: Unit = pq.poll()
      val du: Int = e.get(0)
      val u: Int = e.get(1)
      if (du > dist[u]) {
        continue
      }
      for (nxt in g[u]) {
        val v = nxt[0]
        val w = nxt[1]
        if (dist[v] > dist[u] + w && dist[u] + w < disappear[v]) {
          dist[v] = dist[u] + w
          pq.offer(intArrayOf(dist[v], v))
        }
      }
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      ans[i] = if (dist[i] < disappear[i]) dist[i] else -1
    }
    return ans
  }
}
