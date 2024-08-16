internal class Solution {
  private var x = 0
  private val f: Map<Int, Int> = HashMap()

  fun leastOpsExpressTarget(x: Int, target: Int): Int {
    this.x = x
    return dfs(target)
  }

  private fun dfs(v: Int): Int {
    if (x >= v) {
      return min(v * 2 - 1, 2 * (x - v))
    }
    if (f.containsKey(v)) {
      return f[v]!!
    }
    var k = 2
    var y = x.toLong() * x
    while (y < v) {
      y *= x.toLong()
      ++k
    }
    var ans = k - 1 + dfs(v - (y / x).toInt())
    if (y - v < v) {
      ans = min(ans, k + dfs(y.toInt() - v))
    }
    f.put(v, ans)
    return ans
  }
}
