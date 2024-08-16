internal class Solution {
  fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var ans = 0
    for (i in 1 until points.size) {
      val dx: Int = abs(points[i][0] - points[i - 1][0])
      val dy: Int = abs(points[i][1] - points[i - 1][1])
      ans += max(dx, dy)
    }
    return ans
  }
}
