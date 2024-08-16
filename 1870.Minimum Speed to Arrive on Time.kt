internal class Solution {
  fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
    if (dist.size > ceil(hour)) {
      return -1
    }
    val m = 1e7.toInt()
    var l = 1
    var r = m + 1
    while (l < r) {
      val mid = (l + r) shr 1
      if (check(dist, mid, hour)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return if (l > m) -1 else l
  }

  private fun check(dist: IntArray, v: Int, hour: Double): Boolean {
    var s = 0.0
    val n = dist.size
    for (i in 0 until n) {
      val t = dist[i] * 1.0 / v
      s += if (i == n - 1) t else ceil(t)
    }
    return s <= hour
  }
}
