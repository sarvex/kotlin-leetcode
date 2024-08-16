internal class Solution {
  fun modifiedMatrix(matrix: Array<IntArray>): Array<IntArray> {
    val m = matrix.size
    val n = matrix[0].size
    for (j in 0 until n) {
      var mx = -1
      for (i in 0 until m) {
        mx = max(mx, matrix[i][j])
      }
      for (i in 0 until m) {
        if (matrix[i][j] == -1) {
          matrix[i][j] = mx
        }
      }
    }
    return matrix
  }
}
