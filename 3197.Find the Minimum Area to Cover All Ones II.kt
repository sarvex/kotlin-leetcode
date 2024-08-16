internal class Solution {
  private val inf = 1 shl 30
  private var grid: Array<IntArray>

  fun minimumSum(grid: Array<IntArray>): Int {
    this.grid = grid
    val m = grid.size
    val n = grid[0].size
    var ans = m * n

    for (i1 in 0 until m - 1) {
      for (i2 in i1 + 1 until m - 1) {
        ans = min(
          ans, f(0, 0, i1, n - 1) + f(i1 + 1, 0, i2, n - 1) + f(i2 + 1, 0, m - 1, n - 1)
        )
      }
    }

    for (j1 in 0 until n - 1) {
      for (j2 in j1 + 1 until n - 1) {
        ans = min(
          ans, f(0, 0, m - 1, j1) + f(0, j1 + 1, m - 1, j2) + f(0, j2 + 1, m - 1, n - 1)
        )
      }
    }

    for (i in 0 until m - 1) {
      for (j in 0 until n - 1) {
        ans = min(
          ans, f(0, 0, i, j) + f(0, j + 1, i, n - 1) + f(i + 1, 0, m - 1, n - 1)
        )
        ans = min(
          ans, f(0, 0, i, n - 1) + f(i + 1, 0, m - 1, j) + f(i + 1, j + 1, m - 1, n - 1)
        )

        ans = min(
          ans, f(0, 0, i, j) + f(i + 1, 0, m - 1, j) + f(0, j + 1, m - 1, n - 1)
        )
        ans = min(
          ans, f(0, 0, m - 1, j) + f(0, j + 1, i, n - 1) + f(i + 1, j + 1, m - 1, n - 1)
        )
      }
    }
    return ans
  }

  private fun f(i1: Int, j1: Int, i2: Int, j2: Int): Int {
    var x1 = inf
    var y1 = inf
    var x2 = -inf
    var y2 = -inf
    for (i in i1..i2) {
      for (j in j1..j2) {
        if (grid[i][j] == 1) {
          x1 = min(x1, i)
          y1 = min(y1, j)
          x2 = max(x2, i)
          y2 = max(y2, j)
        }
      }
    }
    return (x2 - x1 + 1) * (y2 - y1 + 1)
  }
}
