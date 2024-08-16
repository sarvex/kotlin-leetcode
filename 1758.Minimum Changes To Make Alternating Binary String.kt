internal class Solution {
  fun minOperations(s: String): Int {
    var cnt = 0
    val n = s.length
    for (i in 0 until n) {
      cnt += (if (s[i] != "01"[i and 1]) 1 else 0)
    }
    return min(cnt, n - cnt)
  }
}
