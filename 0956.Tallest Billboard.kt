internal class Solution {
  private var f: Array<Array<Int>>
  private var rods: IntArray
  private var n = 0

  fun tallestBillboard(rods: IntArray): Int {
    var s = 0
    for (x in rods) {
      s += x
    }
    n = rods.size
    this.rods = rods
    f = Array(n) { arrayOfNulls(s + 1) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= n) {
      return if (j == 0) 0 else -(1 shl 30)
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans: Int = max(dfs(i + 1, j), dfs(i + 1, j + rods[i]))
    ans = max(ans, dfs(i + 1, abs(rods[i] - j)) + min(j, rods[i]))
    return ans.also { f[i][j] = it }
  }
}
