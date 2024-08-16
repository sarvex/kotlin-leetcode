import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var ans = 0
  private var a = 0

  fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
    val d1 = treeDiameter(edges1)
    val d2 = treeDiameter(edges2)
    return max(max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1)
  }

  fun treeDiameter(edges: Array<IntArray>): Int {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    ans = 0
    a = 0
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    dfs(0, -1, 0)
    dfs(a, -1, 0)
    return ans
  }

  private fun dfs(i: Int, fa: Int, t: Int) {
    for (j in g[i]) {
      if (j != fa) {
        dfs(j, i, t + 1)
      }
    }
    if (ans < t) {
      ans = t
      a = i
    }
  }
}
