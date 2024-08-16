import java.util.*

internal class Solution {
  fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
    Arrays.sort(points) { a, b -> a[0] - b[0] }
    var ans = 0
    var x1 = -1
    for (p in points) {
      val x = p[0]
      if (x > x1) {
        ++ans
        x1 = x + w
      }
    }
    return ans
  }
}
