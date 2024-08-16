internal class Solution {
  private val s: Set<Int> = HashSet()
  private var n = 0

  fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
    this.n = n
    for (p in dig) {
      s.add(p[0] * n + p[1])
    }
    var ans = 0
    for (a in artifacts) {
      ans += check(a)
    }
    return ans
  }

  private fun check(a: IntArray): Int {
    val x1 = a[0]
    val y1 = a[1]
    val x2 = a[2]
    val y2 = a[3]
    for (x in x1..x2) {
      for (y in y1..y2) {
        if (!s.contains(x * n + y)) {
          return 0
        }
      }
    }
    return 1
  }
}
