internal class Solution {
  private var d: Array<IntArray>
  private var f: Array<Array<Long>>

  fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {
    d = Array(m + 1) { IntArray(n + 1) }
    f = Array(m + 1) { arrayOfNulls(n + 1) }
    for (p in prices) {
      d[p[0]][p[1]] = p[2]
    }
    return dfs(m, n)
  }

  private fun dfs(h: Int, w: Int): Long {
    if (f[h][w] != null) {
      return f[h][w]
    }
    var ans = d[h][w].toLong()
    for (i in 1 until h / 2 + 1) {
      ans = max(ans, dfs(i, w) + dfs(h - i, w))
    }
    for (i in 1 until w / 2 + 1) {
      ans = max(ans, dfs(h, i) + dfs(h, w - i))
    }
    return ans.also { f[h][w] = it }
  }
}
