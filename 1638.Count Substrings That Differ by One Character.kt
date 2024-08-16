internal class Solution {
  fun countSubstrings(s: String, t: String): Int {
    var ans = 0
    val m = s.length
    val n = t.length
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (s[i] != t[j]) {
          var l = 0
          var r = 0
          while (i - l > 0 && j - l > 0 && s[i - l - 1] == t[j - l - 1]) {
            ++l
          }
          while (i + r + 1 < m && j + r + 1 < n && s[i + r + 1] == t[j + r + 1]) {
            ++r
          }
          ans += (l + 1) * (r + 1)
        }
      }
    }
    return ans
  }
}
