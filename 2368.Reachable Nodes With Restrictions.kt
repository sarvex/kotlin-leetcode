import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var vis: BooleanArray

  fun reachableNodes(n: Int, edges: Array<IntArray>, restricted: IntArray): Int {
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    for (i in restricted) {
      vis[i] = true
    }
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    vis[i] = true
    var ans = 1
    for (j in g[i]) {
      if (!vis[j]) {
        ans += dfs(j)
      }
    }
    return ans
  }
}
