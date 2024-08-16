import java.util.*

internal class Solution {
  fun minimumOperations(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    val f = Array(n) { IntArray(10) }
    val inf = 1 shl 29
    for (g in f) {
      Arrays.fill(g, inf)
    }
    for (i in 0 until n) {
      val cnt = IntArray(10)
      for (j in 0 until m) {
        ++cnt[grid[j][i]]
      }
      if (i == 0) {
        for (j in 0..9) {
          f[i][j] = m - cnt[j]
        }
      } else {
        for (j in 0..9) {
          for (k in 0..9) {
            if (k != j) {
              f[i][j] = min(f[i][j], f[i - 1][k] + m - cnt[j])
            }
          }
        }
      }
    }
    var ans = inf
    for (j in 0..9) {
      ans = min(ans, f[n - 1][j])
    }
    return ans
  }
}
