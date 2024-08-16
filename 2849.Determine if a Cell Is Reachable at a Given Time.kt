internal class Solution {
  fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
    if (sx == fx && sy == fy) {
      return t != 1
    }
    val dx: Int = abs(sx - fx)
    val dy: Int = abs(sy - fy)
    return max(dx, dy) <= t
  }
}
