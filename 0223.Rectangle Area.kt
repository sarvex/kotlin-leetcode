internal class Solution {
  fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    val a = (ax2 - ax1) * (ay2 - ay1)
    val b = (bx2 - bx1) * (by2 - by1)
    val width: Int = min(ax2, bx2) - max(ax1, bx1)
    val height: Int = min(ay2, by2) - max(ay1, by1)
    return a + b - max(height, 0) * max(width, 0)
  }
}
