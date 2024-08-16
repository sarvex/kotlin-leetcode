internal class Solution {
  fun findLatestTime(s: String): String {
    var h = 11
    while (true) {
      for (m in 59 downTo 0) {
        val t: String = String.format("%02d:%02d", h, m)
        var ok = true
        for (i in 0 until s.length) {
          if (s[i] != '?' && s[i] != t[i]) {
            ok = false
            break
          }
        }
        if (ok) {
          return t
        }
      }
      h--
    }
  }
}
