internal class Solution {
  fun maximumInvitations(favorite: IntArray): Int {
    return max(maxCycle(favorite), topologicalSort(favorite))
  }

  private fun maxCycle(fa: IntArray): Int {
    val n = fa.size
    val vis = BooleanArray(n)
    var ans = 0
    for (i in 0 until n) {
      if (vis[i]) {
        continue
      }
      val cycle: List<Int> = ArrayList()
      var j: Int = i
      while (!vis[j]) {
        cycle.add(j)
        vis[j] = true
        j = fa[j]
      }
      for (k in 0 until cycle.size()) {
        if (cycle[k] === j) {
          ans = Math.max(ans, cycle.size() - k)
        }
      }
    }
    return ans
  }

  private fun topologicalSort(fa: IntArray): Int {
    val n = fa.size
    val indeg = IntArray(n)
    val dist = IntArray(n)
    Arrays.fill(dist, 1)
    for (v in fa) {
      indeg[v]++
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    var ans = 0
    while (!q.isEmpty()) {
      val i: Int = q.pollFirst()
      dist[fa[i]] = max(dist[fa[i]], dist[i] + 1)
      if (--indeg[fa[i]] == 0) {
        q.offer(fa[i])
      }
    }
    for (i in 0 until n) {
      if (i == fa[fa[i]]) {
        ans += dist[i]
      }
    }
    return ans
  }
}
