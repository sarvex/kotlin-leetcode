internal class Solution {
  fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val inf = 1 shl 30
    val n = jobDifficulty.size
    val f = Array(n + 1) { IntArray(d + 1) }
    for (g in f) {
      Arrays.fill(g, inf)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 1..min(d, i)) {
        var mx = 0
        for (k in i downTo 1) {
          mx = max(mx, jobDifficulty[k - 1])
          f[i][j] = min(f[i][j], f[k - 1][j - 1] + mx)
        }
      }
    }
    return if (f[n][d] >= inf) -1 else f[n][d]
  }
}
