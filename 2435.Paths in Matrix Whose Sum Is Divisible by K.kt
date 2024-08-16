import java.util.*

internal class Solution {
  private var m = 0
  private var n = 0
  private var k = 0
  private var grid: Array<IntArray>
  private var f: Array<Array<IntArray>>

  fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    this.grid = grid
    this.k = k
    m = grid.size
    n = grid[0].size
    f = Array(m) { Array(n) { IntArray(k) } }
    for (a in f) {
      for (b in a) {
        Arrays.fill(b, -1)
      }
    }
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, s: Int): Int {
    var s = s
    if (i < 0 || i >= m || j < 0 || j >= n) {
      return 0
    }
    s = (s + grid[i][j]) % k
    if (f[i][j][s] != -1) {
      return f[i][j][s]
    }
    if (i == m - 1 && j == n - 1) {
      return if (s == 0) 1 else 0
    }
    var ans = dfs(i + 1, j, s) + dfs(i, j + 1, s)
    ans %= Solution.Companion.MOD
    f[i][j][s] = ans
    return ans
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
