internal class Solution {
  fun videoStitching(clips: Array<IntArray>, time: Int): Int {
    val last = IntArray(time)
    for (e in clips) {
      val a = e[0]
      val b = e[1]
      if (a < time) {
        last[a] = max(last[a], b)
      }
    }
    var ans = 0
    var mx = 0
    var pre = 0
    for (i in 0 until time) {
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
