internal class Solution {
  fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val s = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + mat[i][j]
      }
    }

    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        val x1: Int = max(i - k, 0)
        val y1: Int = max(j - k, 0)
        val x2: Int = min(m - 1, i + k)
        val y2: Int = min(n - 1, j + k)
        ans[i][j] = s[x2 + 1][y2 + 1] - s[x1][y2 + 1] - s[x2 + 1][y1] + s[x1][y1]
      }
    }
    return ans
  }
}
