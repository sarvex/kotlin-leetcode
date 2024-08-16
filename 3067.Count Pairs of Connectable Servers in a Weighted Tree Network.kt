import java.util.*

internal class Solution {
  private var signalSpeed = 0
  private var g: Array<List<IntArray>>

  fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    this.signalSpeed = signalSpeed
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      val w = e[2]
      g[a].add(intArrayOf(b, w))
      g[b].add(intArrayOf(a, w))
    }
    val ans = IntArray(n)
    for (a in 0 until n) {
      var s = 0
      for (e in g[a]) {
        val b = e[0]
        val w = e[1]
        val t = dfs(b, a, w)
        ans[a] += s * t
        s += t
      }
    }
    return ans
  }

  private fun dfs(a: Int, fa: Int, ws: Int): Int {
    var cnt = if (ws % signalSpeed == 0) 1 else 0
    for (e in g[a]) {
      val b = e[0]
      val w = e[1]
      if (b != fa) {
        cnt += dfs(b, a, ws + w)
      }
    }
    return cnt
  }
}
