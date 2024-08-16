internal class Solution {
  fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
    val g = Array(m) { IntArray(n) }
    for (e in indices) {
      val r = e[0]
      val c = e[1]
      for (i in 0 until m) {
        g[i][c]++
      }
      for (j in 0 until n) {
        g[r][j]++
      }
    }
    var ans = 0
    for (row in g) {
      for (v in row) {
        ans += v % 2
      }
    }
    return ans
  }
}
