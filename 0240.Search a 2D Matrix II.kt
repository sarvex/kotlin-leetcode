internal class Solution {
  fun searchMatrix(matrix: Array<IntArray?>, target: Int): Boolean {
    for (row in matrix) {
      val j: Int = Arrays.binarySearch(row, target)
      if (j >= 0) {
        return true
      }
    }
    return false
  }
}
