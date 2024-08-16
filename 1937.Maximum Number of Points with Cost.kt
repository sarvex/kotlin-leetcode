internal class Solution {
  fun maxPoints(points: Array<IntArray>): Long {
    val n = points[0].size
    var f = LongArray(n)
    val inf = 1L shl 60
    for (p in points) {
      val g = LongArray(n)
      var lmx = -inf
      var rmx = -inf
      for (j in 0 until n) {
        lmx = max(lmx, f[j] + j)
        g[j] = max(g[j], p[j] + lmx - j)
      }
      for (j in n - 1 downTo 0) {
        rmx = max(rmx, f[j] - j)
        g[j] = max(g[j], p[j] + rmx + j)
      }
      f = g
    }
    var ans: Long = 0
    for (x in f) {
      ans = max(ans, x)
    }
    return ans
  }
}
