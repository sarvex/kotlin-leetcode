internal class Solution {
  fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val mod = 1e9.toInt() + 7
    val f = Array(n + 1) { IntArray(target + 1) }
    f[0][0] = 1
    for (i in 1..n) {
      for (j in 1..min(target, i * k)) {
        for (h in 1..min(j, k)) {
          f[i][j] = (f[i][j] + f[i - 1][j - h]) % mod
        }
      }
    }
    return f[n][target]
  }
}
