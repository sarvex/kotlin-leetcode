internal class Solution {
  private var g: Array<List<IntArray>>
  private var vis: BooleanArray
  private var values: IntArray
  private var maxTime = 0
  private var ans = 0

  fun maximalPathQuality(values: IntArray, edges: Array<IntArray>, maxTime: Int): Int {
    val n = values.size
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val t = e[2]
      g[u].add(intArrayOf(v, t))
      g[v].add(intArrayOf(u, t))
    }
    vis = BooleanArray(n)
    vis[0] = true
    this.values = values
    this.maxTime = maxTime
    dfs(0, 0, values[0])
    return ans
  }

  private fun dfs(u: Int, cost: Int, value: Int) {
    if (u == 0) {
      ans = max(ans, value)
    }
    for (e in g[u]) {
      val v = e[0]
      val t = e[1]
      if (cost + t <= maxTime) {
        if (vis[v]) {
          dfs(v, cost + t, value)
        } else {
          vis[v] = true
          dfs(v, cost + t, value + values[v])
          vis[v] = false
        }
      }
    }
  }
}
