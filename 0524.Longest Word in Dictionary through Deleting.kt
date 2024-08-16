internal class Solution {
  fun findLongestWord(s: String, dictionary: List<String>): String {
    var ans = ""
    for (t in dictionary) {
      val a = ans.length
      val b = t.length
      if (check(t, s) && (a < b || (a == b && t.compareTo(ans) < 0))) {
        ans = t
      }
    }
    return ans
  }

  private fun check(s: String, t: String): Boolean {
    val m = s.length
    val n = t.length
    var i = 0
    var j = 0
    while (i < m && j < n) {
      if (s[i] == t[j]) {
        ++i
      }
      ++j
    }
    return i == m
  }
}
