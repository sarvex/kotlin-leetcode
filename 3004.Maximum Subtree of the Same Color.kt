import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var colors: IntArray
  private var size: IntArray
  private var ans = 0

  fun maximumSubtreeSize(edges: Array<IntArray>, colors: IntArray): Int {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    size = IntArray(n)
    this.colors = colors
    Arrays.fill(size, 1)
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

  private fun dfs(a: Int, fa: Int): Boolean {
    var ok = true
    for (b in g[a]) {
      if (b != fa) {
        val t = dfs(b, a)
        ok = ok && colors[a] == colors[b] && t
        size[a] += size[b]
      }
    }
    if (ok) {
      ans = max(ans, size[a])
    }
    return ok
  }
}
