import java.util.Deque

internal class Solution {
  fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val n = graph.size
    val indeg = IntArray(n)
    val rg: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(rg) { k -> ArrayList() }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      for (j in graph[i]) {
        rg[j].add(i)
      }
      indeg[i] = graph[i].size
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    while (!q.isEmpty()) {
      val i = q.pollFirst()
      for (j in rg[i]) {
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        ans.add(i)
      }
    }
    return ans
  }
}
