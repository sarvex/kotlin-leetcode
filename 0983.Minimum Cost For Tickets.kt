internal class Solution {
  private val valid = intArrayOf(1, 7, 30)
  private var days: IntArray
  private var costs: IntArray
  private var f: Array<Int>
  private var n = 0

  fun mincostTickets(days: IntArray, costs: IntArray): Int {
    n = days.size
    f = arrayOfNulls(n)
    this.days = days
    this.costs = costs
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    f[i] = MAX_VALUE
    for (k in 0..2) {
      var j: Int = Arrays.binarySearch(days, days[i] + valid[k])
      j = if (j < 0) -j - 1 else j
      f[i] = min(f[i], dfs(j) + costs[k])
    }
    return f[i]
  }
}
