internal class Solution {
  private var s: String? = null
  private var n = 0

  fun maximumLength(s: String): Int {
    this.s = s
    n = s.length
    var l = 0
    var r = n
    while (l < r) {
      val mid = (l + r + 1) shr 1
      if (check(mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return if (l == 0) -1 else l
  }

  private fun check(x: Int): Boolean {
    val cnt = IntArray(26)
    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n && s!![j] == s!![i]) {
        j++
      }
      val k: Int = s!![i].code - 'a'.code
      cnt[k] += max(0, j - i - x + 1)
      if (cnt[k] >= 3) {
        return true
      }
      i = j
    }
    return false
  }
}
