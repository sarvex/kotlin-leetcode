internal class Solution {
  fun maxOperations(s: String): Int {
    var ans = 0
    var cnt = 0
    val n = s.length
    for (i in 0 until n) {
      if (s[i] == '1') {
        ++cnt
      } else if (i > 0 && s[i - 1] == '1') {
        ans += cnt
      }
    }
    return ans
  }
}
