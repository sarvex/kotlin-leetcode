internal class Solution {
  private var f: Array<Array<Array<Int>>>
  private var m = 0
  private var n = 0
  private var minProfit = 0
  private var group: IntArray
  private var profit: IntArray
  private val mod = 1e9.toInt() + 7

  fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
    m = group.size
    this.n = n
    f = Array(m) { Array(n + 1) { arrayOfNulls(minProfit + 1) } }
    this.minProfit = minProfit
    this.group = group
    this.profit = profit
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (i >= m) {
      return if (k == minProfit) 1 else 0
    }
    if (f[i][j][k] != null) {
      return f[i][j][k]
    }
    var ans = dfs(i + 1, j, k)
    if (j + group[i] <= n) {
      ans += dfs(i + 1, j + group[i], min(k + profit[i], minProfit))
    }
    ans %= mod
    return ans.also { f[i][j][k] = it }
  }
}
