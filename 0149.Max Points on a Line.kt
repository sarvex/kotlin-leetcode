internal class Solution {
  fun maxPoints(points: Array<IntArray>): Int {
    val n = points.size
    var ans = 1
    for (i in 0 until n) {
      val x1 = points[i][0]
      val y1 = points[i][1]
      for (j in i + 1 until n) {
        val x2 = points[j][0]
        val y2 = points[j][1]
        var cnt = 2
        for (k in j + 1 until n) {
          val x3 = points[k][0]
          val y3 = points[k][1]
          val a = (y2 - y1) * (x3 - x1)
          val b = (y3 - y1) * (x2 - x1)
          if (a == b) {
            ++cnt
          }
        }
        ans = max(ans, cnt)
      }
    }
    return ans
  }
}
