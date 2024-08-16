internal class Solution {
  fun connectTwoGroups(cost: List<List<Int>>): Int {
    val m: Int = cost.size()
    val n: Int = cost[0].size()
    val inf = 1 shl 30
    val f = Array(m + 1) { IntArray(1 shl n) }
    for (g in f) {
      Arrays.fill(g, inf)
    }
    f[0][0] = 0
    for (i in 1..m) {
      for (j in 0 until (1 shl n)) {
        for (k in 0 until n) {
          if ((j shr k and 1) == 1) {
            val c = cost[i - 1][k]
            f[i][j] = min(f[i][j], f[i][j xor (1 shl k)] + c)
            f[i][j] = min(f[i][j], f[i - 1][j] + c)
            f[i][j] = min(f[i][j], f[i - 1][j xor (1 shl k)] + c)
          }
        }
      }
    }
    return f[m][(1 shl n) - 1]
  }
}
