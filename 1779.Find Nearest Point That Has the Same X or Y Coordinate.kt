internal class Solution {
  fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
    var ans = -1
    var mi = 1000000
    for (i in points.indices) {
      val a = points[i][0]
      val b = points[i][1]
      if (a == x || b == y) {
        val d: Int = abs(a - x) + abs(b - y)
        if (d < mi) {
          mi = d
          ans = i
        }
      }
    }
    return ans
  }
}
