internal class Solution {
  fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
    val n = grid.size
    val cnt1 = IntArray(3)
    val cnt2 = IntArray(3)
    for (i in 0 until n) {
      for (j in 0 until n) {
        val a = i == j && i <= n / 2
        val b = i + j == n - 1 && i <= n / 2
        val c = j == n / 2 && i >= n / 2
        if (a || b || c) {
          ++cnt1[grid[i][j]]
        } else {
          ++cnt2[grid[i][j]]
        }
      }
    }
    var ans = n * n
    for (i in 0..2) {
      for (j in 0..2) {
        if (i != j) {
          ans = min(ans, n * n - cnt1[i] - cnt2[j])
        }
      }
    }
    return ans
  }
}
