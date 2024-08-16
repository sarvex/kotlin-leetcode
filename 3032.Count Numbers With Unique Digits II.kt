internal class Solution {
  private var num: String? = null
  private var f: Array<Array<Int>>

  fun numberCount(a: Int, b: Int): Int {
    num = (a - 1).toString()
    f = Array(num!!.length) { arrayOfNulls(1 shl 10) }
    val x = dfs(0, 0, true)
    num = b.toString()
    f = Array(num!!.length) { arrayOfNulls(1 shl 10) }
    val y = dfs(0, 0, true)
    return y - x
  }

  private fun dfs(pos: Int, mask: Int, limit: Boolean): Int {
    if (pos >= num!!.length) {
      return if (mask > 0) 1 else 0
    }
    if (!limit && f[pos][mask] != null) {
      return f[pos][mask]
    }
    val up = if (limit) num!![pos].code - '0'.code else 9
    var ans = 0
    for (i in 0..up) {
      if ((mask shr i and 1) == 1) {
        continue
      }
      val nxt = if (mask == 0 && i == 0) 0 else mask or (1 shl i)
      ans += dfs(pos + 1, nxt, limit && i == up)
    }
    if (!limit) {
      f[pos][mask] = ans
    }
    return ans
  }
}
