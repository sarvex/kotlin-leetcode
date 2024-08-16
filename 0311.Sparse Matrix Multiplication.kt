internal class Solution {
  fun multiply(mat1: Array<IntArray>, mat2: Array<IntArray>): Array<IntArray> {
    val m = mat1.size
    val n = mat2[0].size
    val ans = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (k in mat2.indices) {
          ans[i][j] += mat1[i][k] * mat2[k][j]
        }
      }
    }
    return ans
  }
}
