internal class Solution {
  fun findLUSlength(strs: Array<String>): Int {
    var ans = -1
    val n = strs.size
    var i = 0
    var j: Int
    while (i < n) {
      var x = strs[i].length
      j = 0
      while (j < n) {
        if (i != j && check(strs[i], strs[j])) {
          x = -1
          break
        }
        ++j
      }
      ans = max(ans, x)
      ++i
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
