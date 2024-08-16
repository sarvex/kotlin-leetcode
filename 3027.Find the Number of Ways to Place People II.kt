import java.util.*

internal class Solution {
  fun numberOfPairs(points: Array<IntArray>): Int {
    Arrays.sort(points) { a, b -> if (a[0] === b[0]) b[1] - a[1] else a[0] - b[0] }
    var ans = 0
    val n = points.size
    val inf = 1 shl 30
    for (i in 0 until n) {
      val y1 = points[i][1]
      var maxY = -inf
      for (j in i + 1 until n) {
        val y2 = points[j][1]
        if (maxY < y2 && y2 <= y1) {
          maxY = y2
          ++ans
        }
      }
    }
    return ans
  }
}
