internal class Solution {
  private val f: Map<List<Int>, Int> = HashMap()
  private var s: String? = null
  private var k = 0

  fun maxPartitionsAfterOperations(s: String?, k: Int): Int {
    this.s = s
    this.k = k
    return dfs(0, 0, 1)
  }

  private fun dfs(i: Int, cur: Int, t: Int): Int {
    if (i >= s!!.length) {
      return 1
    }
    val key = List.of(i, cur, t)
    if (f.containsKey(key)) {
      return f[key]!!
    }
    val v = 1 shl (s!![i].code - 'a'.code)
    var nxt = cur or v
    var ans = if (Integer.bitCount(nxt) > k) dfs(i + 1, v, t) + 1 else dfs(i + 1, nxt, t)
    if (t > 0) {
      for (j in 0..25) {
        nxt = cur or (1 shl j)
        if (Integer.bitCount(nxt) > k) {
          ans = max(ans, dfs(i + 1, 1 shl j, 0) + 1)
        } else {
          ans = max(ans, dfs(i + 1, nxt, 0))
        }
      }
    }
    f.put(key, ans)
    return ans
  }
}
