import java.util.Deque

internal class Solution {
  fun movesToStamp(stamp: String, target: String): IntArray {
    val m = stamp.length
    val n = target.length
    val indeg = IntArray(n - m + 1)
    Arrays.fill(indeg, m)
    val g: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n - m + 1) {
      for (j in 0 until m) {
        if (target[i + j] == stamp[j]) {
          if (--indeg[i] == 0) {
            q.offer(i)
          }
        } else {
          g[i + j].add(i)
        }
      }
    }
    val ans: List<Int> = ArrayList()
    val vis = BooleanArray(n)
    while (!q.isEmpty()) {
      val i = q.poll()
      ans.add(i)
      for (j in 0 until m) {
        if (!vis[i + j]) {
          vis[i + j] = true
          for (k in g[i + j]) {
            if (--indeg[k] == 0) {
              q.offer(k)
            }
          }
        }
      }
    }
    for (i in 0 until n) {
      if (!vis[i]) {
        return IntArray(0)
      }
    }
    Collections.reverse(ans)
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }
}
