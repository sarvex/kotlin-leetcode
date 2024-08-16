internal class Solution {
  fun minimumChairs(s: String): Int {
    var cnt = 0
    var left = 0
    for (i in 0 until s.length) {
      if (s[i] == 'E') {
        if (left > 0) {
          --left
        } else {
          ++cnt
        }
      } else {
        ++left
      }
    }
    return cnt
  }
}
