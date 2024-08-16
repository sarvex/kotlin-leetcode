internal class Solution {
  fun coinChange(coins: IntArray, amount: Int): Int {
    val inf = 1 shl 30
    val m = coins.size
    val n = amount
    val f = Array(m + 1) { IntArray(n + 1) }
    for (g in f) {
      Arrays.fill(g, inf)
    }
    f[0][0] = 0
    for (i in 1..m) {
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (j >= coins[i - 1]) {
          f[i][j] = min(f[i][j], f[i][j - coins[i - 1]] + 1)
        }
      }
    }
    return if (f[m][n] >= inf) -1 else f[m][n]
  }
}
