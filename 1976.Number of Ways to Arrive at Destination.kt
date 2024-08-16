internal class Solution {
  fun countPaths(n: Int, roads: Array<IntArray>): Int {
    val inf: Long = MAX_VALUE / 2
    val mod = 1e9.toInt() + 7
    val g = Array(n) { LongArray(n) }
    for (e in g) {
      Arrays.fill(e, inf)
    }
    for (r in roads) {
      val u = r[0]
      val v = r[1]
      val t = r[2]
      g[u][v] = t.toLong()
      g[v][u] = t.toLong()
    }
    g[0][0] = 0
    val dist = LongArray(n)
    Arrays.fill(dist, inf)
    dist[0] = 0
    val f = LongArray(n)
    f[0] = 1
    val vis = BooleanArray(n)
    for (i in 0 until n) {
      var t = -1
      for (j in 0 until n) {
        if (!vis[j] && (t == -1 || dist[j] < dist[t])) {
          t = j
        }
      }
      vis[t] = true
      for (j in 0 until n) {
        if (j == t) {
          continue
        }
        val ne = dist[t] + g[t][j]
        if (dist[j] > ne) {
          dist[j] = ne
          f[j] = f[t]
        } else if (dist[j] == ne) {
          f[j] = (f[j] + f[t]) % mod
        }
      }
    }
    return f[n - 1].toInt()
  }
}
