internal class Solution {
  fun countSubstrings(s: String): Int {
    var ans = 0
    val n = s.length
    for (k in 0 until n * 2 - 1) {
      var i: Int = k / 2
      var j: Int = (k + 1) / 2
      while (i >= 0 && j < n && s[i] == s[j]) {
        ++ans
        --i
        ++j
      }
    }
    return ans
  }
}
