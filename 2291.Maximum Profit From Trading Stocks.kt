internal class Solution {
  fun maximumProfit(present: IntArray, future: IntArray, budget: Int): Int {
    val n = present.size
    val f = Array(n + 1) { IntArray(budget + 1) }
    for (i in 1..n) {
      for (j in 0..budget) {
        f[i][j] = f[i - 1][j]
        if (j >= present[i - 1]) {
          f[i][j] = max(
            f[i][j], f[i - 1][j - present[i - 1]] + future[i - 1] - present[i - 1]
          )
        }
      }
    }
    return f[n][budget]
  }
}
