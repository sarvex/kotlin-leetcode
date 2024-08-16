internal class Solution {
  private var maxCost = 0
  private var f: IntArray
  private var n = 0

  fun equalSubstring(s: String, t: String, maxCost: Int): Int {
    n = s.length
    f = IntArray(n + 1)
    this.maxCost = maxCost
    for (i in 0 until n) {
      val x: Int = abs(s[i].code - t[i].code)
      f[i + 1] = f[i] + x
    }
    var l = 0
    var r = n
    while (l < r) {
      val mid = (l + r + 1) ushr 1
      if (check(mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun check(x: Int): Boolean {
    var i = 0
    while (i + x - 1 < n) {
      val j = i + x - 1
      if (f[j + 1] - f[i] <= maxCost) {
        return true
      }
      ++i
    }
    return false
  }
}
