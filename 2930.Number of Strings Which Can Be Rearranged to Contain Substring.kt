internal class Solution {
  private val mod = 1e9.toInt() + 7
  private var f: Array<Array<Array<Array<Long>>>>

  fun stringCount(n: Int): Int {
    f = Array(n + 1) { Array(2) { Array(3) { arrayOfNulls(2) } } }
    return dfs(n, 0, 0, 0).toInt()
  }

  private fun dfs(i: Int, l: Int, e: Int, t: Int): Long {
    if (i == 0) {
      return if (l == 1 && e == 2 && t == 1) 1 else 0
    }
    if (f[i][l][e][t] != null) {
      return f[i][l][e][t]
    }
    val a = dfs(i - 1, l, e, t) * 23 % mod
    val b = dfs(i - 1, min(1, l + 1), e, t)
    val c = dfs(i - 1, l, min(2, e + 1), t)
    val d = dfs(i - 1, l, e, min(1, t + 1))
    return ((a + b + c + d) % mod).also { f[i][l][e][t] = it }
  }
}
