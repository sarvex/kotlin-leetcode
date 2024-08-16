import java.util.*

internal class Solution {
  fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
    val req = IntArray(n)
    Arrays.fill(req, -1)
    var m = 0
    for (r in requirements) {
      req[r[0]] = r[1]
      m = max(m, r[1])
    }
    if (req[0] > 0) {
      return 0
    }
    req[0] = 0
    val mod = 1e9.toInt() + 7
    val f = Array(n) { IntArray(m + 1) }
    f[0][0] = 1
    for (i in 1 until n) {
      var l = 0
      var r = m
      if (req[i] >= 0) {
        r = req[i]
        l = r
      }
      for (j in l..r) {
        for (k in 0..min(i, j)) {
          f[i][j] = (f[i][j] + f[i - 1][j - k]) % mod
        }
      }
    }
    return f[n - 1][req[n - 1]]
  }
}
