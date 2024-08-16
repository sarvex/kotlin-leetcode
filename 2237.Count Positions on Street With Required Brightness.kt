internal class Solution {
  fun meetRequirement(n: Int, lights: Array<IntArray>, requirement: IntArray): Int {
    val d = IntArray(100010)
    for (e in lights) {
      val i: Int = max(0, e[0] - e[1])
      val j: Int = min(n - 1, e[0] + e[1])
      ++d[i]
      --d[j + 1]
    }
    var s = 0
    var ans = 0
    for (i in 0 until n) {
      s += d[i]
      if (s >= requirement[i]) {
        ++ans
      }
    }
    return ans
  }
}
