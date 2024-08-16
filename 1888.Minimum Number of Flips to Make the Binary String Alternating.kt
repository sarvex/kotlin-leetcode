internal class Solution {
  fun minFlips(s: String): Int {
    val n = s.length
    val target = "01"
    var cnt = 0
    for (i in 0 until n) {
      if (s[i] != target[i and 1]) {
        ++cnt
      }
    }
    var ans: Int = min(cnt, n - cnt)
    for (i in 0 until n) {
      if (s[i] != target[i and 1]) {
        --cnt
      }
      if (s[i] != target[(i + n) and 1]) {
        ++cnt
      }
      ans = min(ans, min(cnt, n - cnt))
    }
    return ans
  }
}
