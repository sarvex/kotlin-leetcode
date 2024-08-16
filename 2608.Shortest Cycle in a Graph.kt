import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private val inf = 1 shl 30

  fun findShortestCycle(n: Int, edges: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    var ans = inf
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      ans = min(ans, bfs(u, v))
    }
    return if (ans < inf) ans else -1
  }

  private fun bfs(u: Int, v: Int): Int {
    val dist = IntArray(g.size)
    Arrays.fill(dist, inf)
    dist[u] = 0
    val q: Deque<Int> = ArrayDeque()
    q.offer(u)
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      for (j in g[i]) {
        if ((i == u && j == v) || (i == v && j == u) || dist[j] != inf) {
          continue
        }
        dist[j] = dist[i] + 1
        q.offer(j)
      }
    }
    return dist[v] + 1
  }
}
