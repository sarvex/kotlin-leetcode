internal class Solution {
  fun uniquePaths(m: Int, n: Int): Int {
    val f = Array(m) { IntArray(n) }
    f[0][0] = 1
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (i > 0) {
          f[i][j] += f[i - 1][j]
        }
        if (j > 0) {
          f[i][j] += f[i][j - 1]
        }
      }
    }
    return f[m - 1][n - 1]
  }
}
