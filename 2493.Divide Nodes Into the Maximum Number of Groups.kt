import java.util.*

internal class Solution {
  fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
    val g: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0] - 1
      val b = e[1] - 1
      g[a].add(b)
      g[b].add(a)
    }
    val d = IntArray(n)
    val dist = IntArray(n)
    for (i in 0 until n) {
      val q: Deque<Int> = ArrayDeque()
      q.offer(i)
      Arrays.fill(dist, 0)
      dist[i] = 1
      var mx = 1
      var root: Int = i
      while (!q.isEmpty()) {
        val a: Int = q.poll()
        root = min(root, a)
        for (b in g[a]) {
          if (dist[b] == 0) {
            dist[b] = dist[a] + 1
            mx = max(mx, dist[b])
            q.offer(b)
          } else if (abs(dist[b] - dist[a]) != 1) {
            return -1
          }
        }
      }
      d[root] = max(d[root], mx)
    }
    return Arrays.stream(d).sum()
  }
}
