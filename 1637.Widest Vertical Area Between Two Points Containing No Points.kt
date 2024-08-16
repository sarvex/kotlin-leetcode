internal class Solution {
  fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    Arrays.sort(points) { a, b -> a.get(0) - b.get(0) }
    var ans = 0
    for (i in 0 until points.size - 1) {
      ans = max(ans, points[i + 1][0] - points[i][0])
    }
    return ans
  }
}
