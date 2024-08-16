import java.util.*

internal class Solution {
  private var ans = 0
  private var g: Array<List<Int>>

  fun countGoodNodes(edges: Array<IntArray>): Int {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs(0, -1)
    return ans
  }

  private fun dfs(a: Int, fa: Int): Int {
    var pre = -1
    var cnt = 1
    var ok = 1
    for (b in g[a]) {
      if (b != fa) {
        val cur = dfs(b, a)
        cnt += cur
        if (pre < 0) {
          pre = cur
        } else if (pre != cur) {
          ok = 0
        }
      }
    }
    ans += ok
    return cnt
  }
}
