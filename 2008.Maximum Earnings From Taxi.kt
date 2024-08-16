internal class Solution {
  private var m = 0
  private var rides: Array<IntArray>
  private var f: Array<Long>

  fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
    Arrays.sort(rides) { a, b -> a.get(0) - b.get(0) }
    m = rides.size
    f = arrayOfNulls(m)
    this.rides = rides
    return dfs(0)
  }

  private fun dfs(i: Int): Long {
    if (i >= m) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    val r = rides[i]
    val st = r[0]
    val ed = r[1]
    val tip = r[2]
    val j = search(ed, i + 1)
    return max(dfs(i + 1), dfs(j) + ed - st + tip).also { f[i] = it }
  }

  private fun search(x: Int, l: Int): Int {
    var l = l
    var r = m
    while (l < r) {
      val mid = (l + r) shr 1
      if (rides[mid][0] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
