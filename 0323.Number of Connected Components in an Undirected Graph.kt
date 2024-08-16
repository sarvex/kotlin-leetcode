internal class Solution {
  private var g: Array<List<Int>>
  private var vis: BooleanArray

  fun countComponents(n: Int, edges: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    vis = BooleanArray(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    var ans = 0
    for (i in 0 until n) {
      ans += dfs(i)
    }
    return ans
  }

  private fun dfs(i: Int): Int {
    if (vis[i]) {
      return 0
    }
    vis[i] = true
    for (j in g[i]) {
      dfs(j)
    }
    return 1
  }
}
