internal class Solution {
  fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
    val nxt = IntArray(n - 1)
    for (i in 1 until n) {
      nxt[i - 1] = i
    }
    val m = queries.size
    var cnt = n - 1
    val ans = IntArray(m)
    for (i in 0 until m) {
      val u = queries[i][0]
      val v = queries[i][1]
      if (nxt[u] > 0 && nxt[u] < v) {
        var j = nxt[u]
        while (j < v) {
          --cnt
          val t = nxt[j]
          nxt[j] = 0
          j = t
        }
        nxt[u] = v
      }
      ans[i] = cnt
    }
    return ans
  }
}
