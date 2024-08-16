internal class Solution {
  fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
    var ans: Long = 0
    for (i in bottomLeft.indices) {
      val x1 = bottomLeft[i][0]
      val y1 = bottomLeft[i][1]
      val x2 = topRight[i][0]
      val y2 = topRight[i][1]
      for (j in i + 1 until bottomLeft.size) {
        val x3 = bottomLeft[j][0]
        val y3 = bottomLeft[j][1]
        val x4 = topRight[j][0]
        val y4 = topRight[j][1]
        val w: Int = min(x2, x4) - max(x1, x3)
        val h: Int = min(y2, y4) - max(y1, y3)
        val e: Int = min(w, h)
        if (e > 0) {
          ans = max(ans, 1L * e * e)
        }
      }
    }
    return ans
  }
}
