internal class Solution {
  private var destination = 0
  private var vis: BooleanArray
  private var g: Array<List<Int>>

  fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    vis = BooleanArray(n)
    this.destination = destination
    return dfs(source)
  }

  private fun dfs(i: Int): Boolean {
    if (i == destination) {
      return true
    }
    vis[i] = true
    for (j in g[i]) {
      if (!vis[j] && dfs(j)) {
        return true
      }
    }
    return false
  }
}
