internal class Solution {
  private var g: Array<List<IntArray>>

  fun minReorder(n: Int, connections: Array<IntArray>): Int {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in connections) {
      val a = e[0]
      val b = e[1]
      g[a].add(intArrayOf(b, 1))
      g[b].add(intArrayOf(a, 0))
    }
    return dfs(0, -1)
  }

  private fun dfs(a: Int, fa: Int): Int {
    var ans = 0
    for (e in g[a]) {
      val b = e[0]
      val c = e[1]
      if (b != fa) {
        ans += c + dfs(b, a)
      }
    }
    return ans
  }
}
