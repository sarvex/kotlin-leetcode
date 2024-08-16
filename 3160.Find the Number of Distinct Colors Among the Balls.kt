internal class Solution {
  fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
    val g: Map<Int, Int> = HashMap()
    val cnt: Map<Int, Int> = HashMap()
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val x = queries[i][0]
      val y = queries[i][1]
      cnt.merge(y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (g.containsKey(x) && cnt.merge(g[x], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(g[x])
      }
      g.put(x, y)
      ans[i] = cnt.size()
    }
    return ans
  }
}
