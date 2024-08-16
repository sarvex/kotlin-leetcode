import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var n = 0

  fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    this.n = n
    g = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (i in 0 until n - 1) {
      g[i].add(i + 1)
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val u = queries[i][0]
      val v = queries[i][1]
      g[u].add(v)
      ans[i] = bfs(0)
    }
    return ans
  }

  private fun bfs(i: Int): Int {
    val q: Deque<Int> = ArrayDeque()
    q.offer(i)
    val vis = BooleanArray(n)
    vis[i] = true
    var d = 0
    while (true) {
      for (k in q.size() downTo 1) {
        val u: Int = q.poll()
        if (u == n - 1) {
          return d
        }
        for (v in g[u]) {
          if (!vis[v]) {
            vis[v] = true
            q.offer(v)
          }
        }
      }
      ++d
    }
  }
}
