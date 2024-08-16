internal class Solution {
  private var n = 0
  private var g: Array<IntArray>
  private var dist: IntArray
  private var vis: BooleanArray
  private val inf = 1 shl 30
  private var distanceThreshold = 0

  fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
    this.n = n
    this.distanceThreshold = distanceThreshold
    g = Array(n) { IntArray(n) }
    dist = IntArray(n)
    vis = BooleanArray(n)
    for (e in g) {
      Arrays.fill(e, inf)
    }
    for (e in edges) {
      val f = e[0]
      val t = e[1]
      val w = e[2]
      g[f][t] = w
      g[t][f] = w
    }
    var ans = n
    var cnt = inf
    for (i in n - 1 downTo 0) {
      val t = dijkstra(i)
      if (t < cnt) {
        cnt = t
        ans = i
      }
    }
    return ans
  }

  private fun dijkstra(u: Int): Int {
    Arrays.fill(dist, inf)
    Arrays.fill(vis, false)
    dist[u] = 0
    for (i in 0 until n) {
      var k = -1
      for (j in 0 until n) {
        if (!vis[j] && (k == -1 || dist[k] > dist[j])) {
          k = j
        }
      }
      vis[k] = true
      for (j in 0 until n) {
        dist[j] = min(dist[j], dist[k] + g[k][j])
      }
    }
    var cnt = 0
    for (d in dist) {
      if (d <= distanceThreshold) {
        ++cnt
      }
    }
    return cnt
  }
}
