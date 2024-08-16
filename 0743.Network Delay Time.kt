internal class Solution {
  fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val g = Array(n) { IntArray(n) }
    val dist = IntArray(n)
    val vis = BooleanArray(n)
    for (i in 0 until n) {
      dist[i] = Solution.Companion.INF
      Arrays.fill(g[i], Solution.Companion.INF)
    }
    for (t in times) {
      g[t[0] - 1][t[1] - 1] = t[2]
    }
    dist[k - 1] = 0
    for (i in 0 until n) {
      var t = -1
      for (j in 0 until n) {
        if (!vis[j] && (t == -1 || dist[t] > dist[j])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 0 until n) {
        dist[j] = min(dist[j], dist[t] + g[t][j])
      }
    }
    var ans = 0
    for (d in dist) {
      ans = max(ans, d)
    }
    return if (ans == Solution.Companion.INF) -1 else ans
  }

  companion object {
    private const val INF = 0x3f3f
  }
}
