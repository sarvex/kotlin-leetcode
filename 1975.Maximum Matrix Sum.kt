internal class Solution {
  fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var s: Long = 0
    var cnt = 0
    var mi: Int = MAX_VALUE
    for (row in matrix) {
      for (v in row) {
        s += abs(v)
        mi = min(mi, abs(v))
        if (v < 0) {
          ++cnt
        }
      }
    }
    if (cnt % 2 == 0 || mi == 0) {
      return s
    }
    return s - mi * 2
  }
}
