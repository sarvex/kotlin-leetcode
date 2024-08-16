internal class Solution {
  fun maximumGain(s: String, x: Int, y: Int): Int {
    var x = x
    var y = y
    var a = 'a'
    var b = 'b'
    if (x < y) {
      val t = x
      x = y
      y = t
      val c = a
      a = b
      b = c
    }
    var ans = 0
    var cnt1 = 0
    var cnt2 = 0
    val n = s.length
    for (i in 0 until n) {
      val c = s[i]
      if (c == a) {
        cnt1++
      } else if (c == b) {
        if (cnt1 > 0) {
          ans += x
          cnt1--
        } else {
          cnt2++
        }
      } else {
        ans += min(cnt1, cnt2) * y
        cnt1 = 0
        cnt2 = 0
      }
    }
    ans += min(cnt1, cnt2) * y
    return ans
  }
}
