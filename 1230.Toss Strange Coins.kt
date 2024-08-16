internal class Solution {
  fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
    val n = prob.size
    val f = Array(n + 1) { DoubleArray(target + 1) }
    f[0][0] = 1.0
    for (i in 1..n) {
      for (j in 0..min(i, target)) {
        f[i][j] = (1 - prob[i - 1]) * f[i - 1][j]
        if (j > 0) {
          f[i][j] += prob[i - 1] * f[i - 1][j - 1]
        }
      }
    }
    return f[n][target]
  }
}
