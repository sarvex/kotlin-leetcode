internal class Solution {
  private var x = 0
  private var num: Long = 0
  private var f: Array<Array<Long>>

  fun findMaximumNumber(k: Long, x: Int): Long {
    this.x = x
    var l: Long = 1
    var r = 1e17.toLong()
    while (l < r) {
      val mid = (l + r + 1) ushr 1
      num = mid
      f = Array(65) { arrayOfNulls(65) }
      val pos = 64 - java.lang.Long.numberOfLeadingZeros(mid)
      if (dfs(pos, 0, true) <= k) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun dfs(pos: Int, cnt: Int, limit: Boolean): Long {
    if (pos == 0) {
      return cnt.toLong()
    }
    if (!limit && f[pos][cnt] != null) {
      return f[pos][cnt]
    }
    var ans: Long = 0
    val up = if (limit) (num shr (pos - 1) and 1L).toInt() else 1
    for (i in 0..up) {
      ans += dfs(pos - 1, cnt + (if (i == 1 && pos % x == 0) 1 else 0), limit && i == up)
    }
    if (!limit) {
      f[pos][cnt] = ans
    }
    return ans
  }
}
