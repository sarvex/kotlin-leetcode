internal class Solution {
  fun change(amount: Int, coins: IntArray): Int {
    val m = coins.size
    val n = amount
    val f = Array(m + 1) { IntArray(n + 1) }
    f[0][0] = 1
    for (i in 1..m) {
      for (j in 0..n) {
        f[i][j] = f[i - 1][j]
        if (j >= coins[i - 1]) {
          f[i][j] += f[i][j - coins[i - 1]]
        }
      }
    }
    return f[m][n]
  }
}
