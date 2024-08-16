internal class Solution {
  private val f: Map<Int, Int> = HashMap()
  private var y = 0

  fun minimumOperationsToMakeEqual(x: Int, y: Int): Int {
    this.y = y
    return dfs(x)
  }

  private fun dfs(x: Int): Int {
    if (y >= x) {
      return y - x
    }
    if (f.containsKey(x)) {
      return f[x]!!
    }
    var ans = x - y
    val a = x % 5 + 1 + dfs(x / 5)
    val b = 5 - x % 5 + 1 + dfs(x / 5 + 1)
    val c = x % 11 + 1 + dfs(x / 11)
    val d = 11 - x % 11 + 1 + dfs(x / 11 + 1)
    ans = min(ans, min(a, min(b, min(c, d))))
    f.put(x, ans)
    return ans
  }
}
