internal class Solution {
  fun simulationResult(windows: IntArray, queries: IntArray): IntArray {
    val n = windows.size
    val s = BooleanArray(n + 1)
    val ans = IntArray(n)
    var k = 0
    for (i in queries.indices.reversed()) {
      val q = queries[i]
      if (!s[q]) {
        ans[k++] = q
        s[q] = true
      }
    }
    for (w in windows) {
      if (!s[w]) {
        ans[k++] = w
      }
    }
    return ans
  }
}
