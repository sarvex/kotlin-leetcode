import java.util.*

internal class Solution {
  private var hens: IntArray
  private var grains: IntArray
  private var m = 0

  fun minimumTime(hens: IntArray, grains: IntArray): Int {
    m = grains.size
    this.hens = hens
    this.grains = grains
    Arrays.sort(hens)
    Arrays.sort(grains)
    var l = 0
    var r: Int = abs(hens[0] - grains[0]) + grains[m - 1] - grains[0]
    while (l < r) {
      val mid = (l + r) shr 1
      if (check(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun check(t: Int): Boolean {
    var j = 0
    for (x in hens) {
      if (j == m) {
        return true
      }
      val y = grains[j]
      if (y <= x) {
        val d = x - y
        if (d > t) {
          return false
        }
        while (j < m && grains[j] <= x) {
          ++j
        }
        while (j < m && min(d, grains[j] - x) + grains[j] - y <= t) {
          ++j
        }
      } else {
        while (j < m && grains[j] - x <= t) {
          ++j
        }
      }
    }
    return j == m
  }
}
