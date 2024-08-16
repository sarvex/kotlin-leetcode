internal class Solution {
  private var events: Array<IntArray>
  private var f: Array<IntArray>
  private var n = 0

  fun maxValue(events: Array<IntArray>, k: Int): Int {
    Arrays.sort(events) { a, b -> a.get(0) - b.get(0) }
    this.events = events
    n = events.size
    f = Array(n) { IntArray(k + 1) }
    return dfs(0, k)
  }

  private fun dfs(i: Int, k: Int): Int {
    if (i >= n || k <= 0) {
      return 0
    }
    if (f[i][k] != 0) {
      return f[i][k]
    }
    val j = search(events, events[i][1], i + 1)
    val ans: Int = max(dfs(i + 1, k), dfs(j, k - 1) + events[i][2])
    return ans.also { f[i][k] = it }
  }

  private fun search(events: Array<IntArray>, x: Int, lo: Int): Int {
    var l = lo
    var r = n
    while (l < r) {
      val mid = (l + r) shr 1
      if (events[mid][0] > x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
