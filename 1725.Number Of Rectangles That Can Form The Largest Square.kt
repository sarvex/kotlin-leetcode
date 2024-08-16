internal class Solution {
  fun countGoodRectangles(rectangles: Array<IntArray>): Int {
    var ans = 0
    var mx = 0
    for (e in rectangles) {
      val x: Int = min(e[0], e[1])
      if (mx < x) {
        mx = x
        ans = 1
      } else if (mx == x) {
        ++ans
      }
    }
    return ans
  }
}
