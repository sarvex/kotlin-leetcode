internal class Solution {
  fun doesAliceWin(s: String): Boolean {
    for (i in 0 until s.length) {
      if ("aeiou".indexOf(s[i]) != -1) {
        return true
      }
    }
    return false
  }
}
