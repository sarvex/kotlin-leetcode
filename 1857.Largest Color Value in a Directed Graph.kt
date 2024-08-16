internal class Solution {
  fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val n = colors.length
    val g: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val indeg = IntArray(n)
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      ++indeg[b]
    }
    val q: Deque<Int> = ArrayDeque()
    val dp = Array(n) { IntArray(26) }
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        q.offer(i)
        val c: Int = colors[i].code - 'a'.code
        ++dp[i][c]
      }
    }
    var cnt = 0
    var ans = 1
    while (!q.isEmpty()) {
      val i: Int = q.pollFirst()
      ++cnt
      for (j in g[i]) {
        if (--indeg[j] == 0) {
          q.offer(j)
        }
        val c: Int = colors[j].code - 'a'.code
        for (k in 0..25) {
          dp[j][k] = max(dp[j][k], dp[i][k] + (if (c == k) 1 else 0))
          ans = max(ans, dp[j][k])
        }
      }
    }
    return if (cnt == n) ans else -1
  }
}
