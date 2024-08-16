internal class Solution {
  fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val n = matrix.size
    var f = IntArray(n)
    for (row in matrix) {
      val g = f.clone()
      for (j in 0 until n) {
        if (j > 0) {
          g[j] = min(g[j], f[j - 1])
        }
        if (j + 1 < n) {
          g[j] = min(g[j], f[j + 1])
        }
        g[j] += row[j]
      }
      f = g
    }
    // return Arrays.stream(f).min().getAsInt();
    var ans = 1 shl 30
    for (x in f) {
      ans = min(ans, x)
    }
    return ans
  }
}
