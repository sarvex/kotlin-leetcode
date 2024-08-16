internal class Solution {
  private var s: CharArray
  private var f: Array<Array<Int>>

  fun findIntegers(n: Int): Int {
    s = Integer.toBinaryString(n).toCharArray()
    f = Array(s.size) { arrayOfNulls(2) }
    return dfs(0, 0, true)
  }

  private fun dfs(pos: Int, pre: Int, limit: Boolean): Int {
    if (pos >= s.size) {
      return 1
    }
    if (!limit && f[pos][pre] != null) {
      return f[pos][pre]
    }
    val up = if (limit) s[pos].code - '0'.code else 1
    var ans = 0
    for (i in 0..up) {
      if (!(pre == 1 && i == 1)) {
        ans += dfs(pos + 1, i, limit && i == up)
      }
    }
    if (!limit) {
      f[pos][pre] = ans
    }
    return ans
  }
}
