internal class Solution {
  fun maximumDetonation(bombs: Array<IntArray>): Int {
    val n = bombs.size
    val g: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n - 1) {
      for (j in i + 1 until n) {
        val p1 = bombs[i]
        val p2 = bombs[j]
        val dist: Double = hypot(p1[0] - p2[0], p1[1] - p2[1])
        if (dist <= p1[2]) {
          g[i].add(j)
        }
        if (dist <= p2[2]) {
          g[j].add(i)
        }
      }
    }
    var ans = 0
    val vis = BooleanArray(n)
    for (k in 0 until n) {
      Arrays.fill(vis, false)
      vis[k] = true
      var cnt = 0
      val q: Deque<Int> = ArrayDeque()
      q.offer(k)
      while (!q.isEmpty()) {
        val i: Int = q.poll()
        ++cnt
        for (j in g[i]) {
          if (!vis[j]) {
            vis[j] = true
            q.offer(j)
          }
        }
      }
      if (cnt == n) {
        return n
      }
      ans = max(ans, cnt)
    }
    return ans
  }
}
