internal class Solution {
  fun countTime(time: String): Int {
    var ans = 0
    for (h in 0..23) {
      for (m in 0..59) {
        val s: String = String.format("%02d:%02d", h, m)
        var ok = 1
        for (i in 0..4) {
          if (s[i] != time[i] && time[i] != '?') {
            ok = 0
            break
          }
        }
        ans += ok
      }
    }
    return ans
  }
}
