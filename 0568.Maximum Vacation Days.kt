internal class Solution {
  fun maxVacationDays(flights: Array<IntArray>, days: Array<IntArray>): Int {
    val n = flights.size
    val K = days[0].size
    val inf = 1 shl 30
    val f = Array(K + 1) { IntArray(n) }
    for (g in f) {
      Arrays.fill(g, -inf)
    }
    f[0][0] = 0
    for (k in 1..K) {
      for (j in 0 until n) {
        f[k][j] = f[k - 1][j]
        for (i in 0 until n) {
          if (flights[i][j] == 1) {
            f[k][j] = max(f[k][j], f[k - 1][i])
          }
        }
        f[k][j] += days[j][k - 1]
      }
    }
    var ans = 0
    for (j in 0 until n) {
      ans = max(ans, f[K][j])
    }
    return ans
  }
}
