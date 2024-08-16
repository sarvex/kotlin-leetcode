internal class Solution {
  private var f: Array<Int>
  private var cost: IntArray

  fun minCostClimbingStairs(cost: IntArray): Int {
    this.cost = cost
    f = arrayOfNulls(cost.size)
    return min(dfs(0), dfs(1))
  }

  private fun dfs(i: Int): Int {
    if (i >= cost.size) {
      return 0
    }
    if (f[i] == null) {
      f[i] = cost[i] + min(dfs(i + 1), dfs(i + 2))
    }
    return f[i]
  }
}
