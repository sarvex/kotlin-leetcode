internal class Solution {
  fun mergeTriplets(triplets: Array<IntArray>, target: IntArray): Boolean {
    val x = target[0]
    val y = target[1]
    val z = target[2]
    var d = 0
    var e = 0
    var f = 0
    for (t in triplets) {
      val a = t[0]
      val b = t[1]
      val c = t[2]
      if (a <= x && b <= y && c <= z) {
        d = max(d, a)
        e = max(e, b)
        f = max(f, c)
      }
    }
    return d == x && e == y && f == z
  }
}
