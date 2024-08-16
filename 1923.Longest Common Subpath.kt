internal class Solution {
  @kotlin.jvm.JvmField
  var N: Int = 100010
  var h: LongArray = LongArray(N)
  var p: LongArray = LongArray(N)
  private var paths: Array<IntArray>
  @kotlin.jvm.JvmField
  var cnt: Map<Long, Int> = HashMap()
  var inner: Map<Long, Int> = HashMap()

  fun longestCommonSubpath(n: Int, paths: Array<IntArray>): Int {
    var left = 0
    var right = N
    for (path in paths) {
      right = min(right, path.size)
    }
    this.paths = paths
    while (left < right) {
      val mid = (left + right + 1) shr 1
      if (check(mid)) {
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }

  private fun check(mid: Int): Boolean {
    cnt.clear()
    inner.clear()
    p[0] = 1
    for (j in paths.indices) {
      val n = paths[j].size
      for (i in 1..n) {
        p[i] = p[i - 1] * 133331
        h[i] = h[i - 1] * 133331 + paths[j][i - 1]
      }
      for (i in mid..n) {
        val `val` = get(i - mid + 1, i)
        if (!inner.containsKey(`val`) || inner[`val`] !== j) {
          inner.put(`val`, j)
          cnt.put(`val`, cnt.getOrDefault(`val`, 0) + 1)
        }
      }
    }
    var max = 0
    for (`val` in cnt.values()) {
      max = max(max, `val`)
    }
    return max == paths.size
  }

  private fun get(l: Int, r: Int): Long {
    return h[r] - h[l - 1] * p[r - l + 1]
  }
}
