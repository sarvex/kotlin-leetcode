internal class Solution {
  private var s: String? = null
  private var t: String? = null
  private var f: Array<Long>
  private var limit = 0

  fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String?): Long {
    this.s = s
    this.limit = limit
    t = (start - 1).toString()
    f = arrayOfNulls(20)
    val a = dfs(0, true)
    t = finish.toString()
    f = arrayOfNulls(20)
    val b = dfs(0, true)
    return b - a
  }

  private fun dfs(pos: Int, lim: Boolean): Long {
    if (t!!.length < s!!.length) {
      return 0
    }
    if (!lim && f[pos] != null) {
      return f[pos]
    }
    if (t!!.length - pos == s!!.length) {
      return if (lim) (if (s!!.compareTo(t.substring(pos)) <= 0) 1 else 0) else 1
    }
    var up = if (lim) t!![pos].code - '0'.code else 9
    up = min(up, limit)
    var ans: Long = 0
    for (i in 0..up) {
      ans += dfs(pos + 1, lim && i == (t!![pos].code - '0'.code))
    }
    if (!lim) {
      f[pos] = ans
    }
    return ans
  }
}
