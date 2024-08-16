internal class Solution {
  fun findPeakGrid(mat: Array<IntArray>): IntArray {
    var l = 0
    var r = mat.size - 1
    val n = mat[0].size
    while (l < r) {
      val mid = (l + r) shr 1
      val j = maxPos(mat[mid])
      if (mat[mid][j] > mat[mid + 1][j]) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return intArrayOf(l, maxPos(mat[l]))
  }

  private fun maxPos(arr: IntArray): Int {
    var j = 0
    for (i in 1 until arr.size) {
      if (arr[j] < arr[i]) {
        j = i
      }
    }
    return j
  }
}
