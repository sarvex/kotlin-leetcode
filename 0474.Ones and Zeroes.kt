internal class Solution {
  fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    val sz = strs.size
    val f = Array(sz + 1) { Array(m + 1) { IntArray(n + 1) } }
    for (i in 1..sz) {
      val cnt = count(strs[i - 1])
      for (j in 0..m) {
        for (k in 0..n) {
          f[i][j][k] = f[i - 1][j][k]
          if (j >= cnt[0] && k >= cnt[1]) {
            f[i][j][k] = max(f[i][j][k], f[i - 1][j - cnt[0]][k - cnt[1]] + 1)
          }
        }
      }
    }
    return f[sz][m][n]
  }

  private fun count(s: String): IntArray {
    val cnt = IntArray(2)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - '0'.code]
    }
    return cnt
  }
}
