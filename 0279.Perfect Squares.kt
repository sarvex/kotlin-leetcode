internal class Solution {
  fun numSquares(n: Int): Int {
    val m = sqrt(n) as Int
    val f = Array(m + 1) { IntArray(n + 1) }
    for (g in f) {
      Arrays.fill(g, 1 shl 30)
    }
    f[0][0] = 0
    for (i in 1..m) {
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (j >= i * i) {
          f[i][j] = min(f[i][j], f[i][j - i * i] + 1)
        }
      }
    }
    return f[m][n]
  }
}
