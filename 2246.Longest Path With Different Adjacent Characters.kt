import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var s: String? = null
  private var ans = 0

  fun longestPath(parent: IntArray, s: String?): Int {
    val n = parent.size
    g = arrayOfNulls(n)
    this.s = s
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 1 until n) {
      g[parent[i]].add(i)
    }
    dfs(0)
    return ans + 1
  }

  private fun dfs(i: Int): Int {
    var mx = 0
    for (j in g[i]) {
      val x = dfs(j) + 1
      if (s!![i] != s!![j]) {
        ans = max(ans, mx + x)
        mx = max(mx, x)
      }
    }
    return mx
  }
}
