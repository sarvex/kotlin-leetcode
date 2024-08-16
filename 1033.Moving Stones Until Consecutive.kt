internal class Solution {
  fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
    val x: Int = min(a, min(b, c))
    val z: Int = max(a, max(b, c))
    val y = a + b + c - x - z
    var mi = 0
    var mx = 0
    if (z - x > 2) {
      mi = if (y - x < 3 || z - y < 3) 1 else 2
      mx = z - x - 2
    }
    return intArrayOf(mi, mx)
  }
}
