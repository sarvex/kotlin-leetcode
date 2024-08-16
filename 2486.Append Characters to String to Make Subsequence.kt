internal class Solution {
  fun appendCharacters(s: String, t: String): Int {
    val n = t.length
    var j = 0
    var i = 0
    while (i < s.length && j < n) {
      if (s[i] == t[j]) {
        ++j
      }
      ++i
    }
    return n - j
  }
}
