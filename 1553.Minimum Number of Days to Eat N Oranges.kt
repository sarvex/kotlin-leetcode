internal class Solution {
  private val f: Map<Int, Int> = HashMap()

  fun minDays(n: Int): Int {
    return dfs(n)
  }

  private fun dfs(n: Int): Int {
    if (n < 2) {
      return n
    }
    if (f.containsKey(n)) {
      return f[n]!!
    }
    val res: Int = 1 + min(n % 2 + dfs(n / 2), n % 3 + dfs(n / 3))
    f.put(n, res)
    return res
  }
}
