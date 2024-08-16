import java.util.*

internal class Solution {
  private var g: Array<List<Int>>
  private var ans: Long = 0
  private var price: IntArray

  fun maxOutput(n: Int, edges: Array<IntArray>, price: IntArray): Long {
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    this.price = price
    dfs(0, -1)
    return ans
  }

  private fun dfs(i: Int, fa: Int): LongArray {
    var a = price[i].toLong()
    var b: Long = 0
    for (j in g[i]) {
      if (j != fa) {
        val e = dfs(j, i)
        val c = e[0]
        val d = e[1]
        ans = max(ans, max(a + d, b + c))
        a = max(a, price[i] + c)
        b = max(b, price[i] + d)
      }
    }
    return longArrayOf(a, b)
  }
}
