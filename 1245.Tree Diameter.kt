internal class Solution {
  private var g: Array<List<Int>>
  private var ans = 0
  private var a = 0

  fun treeDiameter(edges: Array<IntArray>): Int {
    val n = edges.size + 1
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
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
