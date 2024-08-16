internal class Solution {
  fun minTaps(n: Int, ranges: IntArray): Int {
    val last = IntArray(n + 1)
    for (i in 0 until n + 1) {
      val l: Int = max(0, i - ranges[i])
      val r: Int = i + ranges[i]
      last[l] = max(last[l], r)
    }
    var ans = 0
    var mx = 0
    var pre = 0
    for (i in 0 until n) {
      mx = max(mx, last[i])
      if (mx <= i) {
        return -1
      }
      if (pre == i) {
        ++ans
        pre = mx
      }
    }
    return ans
  }
}
