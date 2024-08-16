import java.util.*

internal class Solution {
  fun numberOfSets(n: Int, maxDistance: Int, roads: Array<IntArray>): Int {
    var ans = 0
    for (mask in 0 until (1 shl n)) {
      val g = Array(n) { IntArray(n) }
      for (e in g) {
        Arrays.fill(e, 1 shl 29)
      }
      for (e in roads) {
        val u = e[0]
        val v = e[1]
        val w = e[2]
        if ((mask shr u and 1) == 1 && (mask shr v and 1) == 1) {
          g[u][v] = min(g[u][v], w)
          g[v][u] = min(g[v][u], w)
        }
      }
      for (k in 0 until n) {
        if ((mask shr k and 1) == 1) {
          g[k][k] = 0
          for (i in 0 until n) {
            for (j in 0 until n) {
              g[i][j] = min(g[i][j], g[i][k] + g[k][j])
            }
          }
        }
      }
      var ok = 1
      var i = 0
      while (i < n && ok == 1) {
        var j = 0
        while (j < n && ok == 1) {
          if ((mask shr i and 1) == 1 && (mask shr j and 1) == 1) {
            if (g[i][j] > maxDistance) {
              ok = 0
            }
          }
          ++j
        }
        ++i
      }
      ans += ok
    }
    return ans
  }
}
