internal class Solution {
  fun luckyNumbers(matrix: Array<IntArray>): List<Int> {
    val m = matrix.size
    val n = matrix[0].size
    val rows = IntArray(m)
    val cols = IntArray(n)
    Arrays.fill(rows, 1 shl 30)
    for (i in 0 until m) {
      for (j in 0 until n) {
        rows[i] = min(rows[i], matrix[i][j])
        cols[j] = max(cols[j], matrix[i][j])
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (rows[i] == cols[j]) {
          ans.add(rows[i])
        }
      }
    }
    return ans
  }
}
