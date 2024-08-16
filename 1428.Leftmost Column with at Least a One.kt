/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
</Integer> */
internal class Solution {
  fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    val e: List<Int> = binaryMatrix.dimensions()
    val m = e[0]
    val n = e[1]
    var ans = n
    for (i in 0 until m) {
      var l = 0
      var r = n
      while (l < r) {
        val mid = (l + r) shr 1
        if (binaryMatrix.get(i, mid) === 1) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      ans = min(ans, l)
    }
    return if (ans >= n) -1 else ans
  }
}
