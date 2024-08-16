internal class Solution {
  fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
    var f: Set<Int> = HashSet()
    f.add(0)
    for (row in mat) {
      val g: Set<Int> = HashSet()
      for (a in f) {
        for (b in row) {
          g.add(a + b)
        }
      }
      f = g
    }
    var ans = 1 shl 30
    for (v in f) {
      ans = min(ans, abs(v - target))
    }
    return ans
  }
}
