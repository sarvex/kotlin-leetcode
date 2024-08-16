internal class Solution {
  fun getMoneyAmount(n: Int): Int {
    val f = Array(n + 1) { IntArray(n + 1) }
    for (i in n - 1 downTo 1) {
      for (j in i + 1..n) {
        f[i][j] = j + f[i][j - 1]
        for (k in i until j) {
          f[i][j] = min(f[i][j], max(f[i][k - 1], f[k + 1][j]) + k)
        }
      }
    }
    return f[1][n]
  }
}
