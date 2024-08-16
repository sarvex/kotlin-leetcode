internal class Solution {
  private val dirs1 = intArrayOf(-1, 0, 1, 0, -1)
  private val dirs2 = intArrayOf(-1, 1, 1, -1, -1)
  private var e = 0
  private var f = 0

  fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
    this.e = e
    this.f = f
    return if (check(dirs1, a, b, c, d) || check(dirs2, c, d, a, b)) 1 else 2
  }

  private fun check(dirs: IntArray, sx: Int, sy: Int, bx: Int, by: Int): Boolean {
    for (d in 0..3) {
      for (k in 1..7) {
        val x = sx + dirs[d] * k
        val y = sy + dirs[d + 1] * k
        if (x < 1 || x > 8 || y < 1 || y > 8 || (x == bx && y == by)) {
          break
        }
        if (x == e && y == f) {
          return true
        }
      }
    }
    return false
  }
}
