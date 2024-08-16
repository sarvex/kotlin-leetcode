internal class Solution {
  fun minFlipsMonoIncr(s: String): Int {
    val n = s.length
    var tot = 0
    for (i in 0 until n) {
      if (s[i] == '0') {
        ++tot
      }
    }
    var ans = tot
    var cur = 0
    for (i in 1..n) {
      if (s[i - 1] == '0') {
        ++cur
      }
      ans = min(ans, i - cur + tot - cur)
    }
    return ans
  }
}
