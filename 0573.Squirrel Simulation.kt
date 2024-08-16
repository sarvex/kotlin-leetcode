internal class Solution {
  fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
    var ans: Int = MAX_VALUE
    var s = 0
    for (a in nuts) {
      s += f(a, tree)
    }
    s *= 2
    for (a in nuts) {
      val c = f(a, tree)
      val d = f(a, squirrel) + c
      ans = min(ans, s + d - c * 2)
    }
    return ans
  }

  private fun f(a: IntArray, b: IntArray): Int {
    return abs(a[0] - b[0]) + abs(a[1] - b[1])
  }
}
