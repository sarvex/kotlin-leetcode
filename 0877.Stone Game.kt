internal class Solution {
  private var piles: IntArray
  private var f: Array<IntArray>

  fun stoneGame(piles: IntArray): Boolean {
    this.piles = piles
    val n = piles.size
    f = Array(n) { IntArray(n) }
    return dfs(0, n - 1) > 0
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j) {
      return 0
    }
    if (f[i][j] != 0) {
      return f[i][j]
    }
    return max(piles[i] - dfs(i + 1, j), piles[j] - dfs(i, j - 1)).also { f[i][j] = it }
  }
}
