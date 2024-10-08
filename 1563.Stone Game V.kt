internal class Solution {
  private var n = 0
  private var s: IntArray
  private var stoneValue: IntArray
  private var f: Array<Array<Int>>

  fun stoneGameV(stoneValue: IntArray): Int {
    n = stoneValue.size
    this.stoneValue = stoneValue
    s = IntArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + stoneValue[i - 1]
    }
    f = Array(n) { arrayOfNulls(n) }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i == j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 0
    var a = 0
    for (k in i until j) {
      a += stoneValue[k]
      val b = s[j + 1] - s[i] - a
      if (a < b) {
        if (ans >= a * 2) {
          continue
        }
        ans = max(ans, a + dfs(i, k))
      } else if (a > b) {
        if (ans >= b * 2) {
          break
        }
        ans = max(ans, b + dfs(k + 1, j))
      } else {
        ans = max(ans, max(a + dfs(i, k), b + dfs(k + 1, j)))
      }
    }
    return ans.also { f[i][j] = it }
  }
}
