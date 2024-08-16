internal class Solution {
  fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    var times = 4
    while (times-- > 0) {
      if (equals(mat, target)) {
        return true
      }
      rotate(mat)
    }
    return false
  }

  private fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until n / 2) {
      for (j in i until n - 1 - i) {
        val t = matrix[i][j]
        matrix[i][j] = matrix[n - j - 1][i]
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]
        matrix[j][n - i - 1] = t
      }
    }
  }

  private fun equals(nums1: Array<IntArray>, nums2: Array<IntArray>): Boolean {
    val n = nums1.size
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (nums1[i][j] != nums2[i][j]) {
          return false
        }
      }
    }
    return true
  }
}
