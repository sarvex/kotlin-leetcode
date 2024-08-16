internal class Solution {
  private var f: Array<Array<Int>>
  private var g: Array<IntArray>

  fun mctFromLeafValues(arr: IntArray): Int {
    val n = arr.size
    f = Array(n) { arrayOfNulls(n) }
    g = Array(n) { IntArray(n) }
    for (i in n - 1 downTo 0) {
      g[i][i] = arr[i]
      for (j in i + 1 until n) {
        g[i][j] = max(g[i][j - 1], arr[j])
      }
    }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i == j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 1 shl 30
    for (k in i until j) {
      ans = min(ans, dfs(i, k) + dfs(k + 1, j) + g[i][k] * g[k + 1][j])
    }
    return ans.also { f[i][j] = it }
  }
}
