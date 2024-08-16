import java.util.Arrays

internal class Solution {
  private var cost: IntArray
  private var g: Array<List<Int>>
  private var ans: LongArray

  fun placedCoins(edges: Array<IntArray>, cost: IntArray): LongArray {
    val n = cost.size
    this.cost = cost
    ans = LongArray(n)
    g = arrayOfNulls(n)
    Arrays.fill(ans, 1)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs(0, -1)
    return ans
  }

  private fun dfs(a: Int, fa: Int): List<Int> {
    var res: List<Int> = ArrayList()
    res.add(cost[a])
    for (b in g[a]) {
      if (b != fa) {
        res.addAll(dfs(b, a))
      }
    }
    Collections.sort(res)
    val m: Int = res.size()
    if (m >= 3) {
      val x = res[m - 1] as Long * res[m - 2] * res[m - 3]
      val y = res[0] as Long * res[1] * res[m - 1]
      ans[a] = max(0, max(x, y))
    }
    if (m >= 5) {
      res = List.of(res[0], res[1], res[m - 3], res[m - 2], res[m - 1])
    }
    return res
  }
}
