internal class Solution {
  fun minimumTime(s: String): Int {
    val n = s.length
    val pre = IntArray(n + 1)
    val suf = IntArray(n + 1)
    for (i in 0 until n) {
      pre[i + 1] = if (s[i] == '0') pre[i] else min(pre[i] + 2, i + 1)
    }
    for (i in n - 1 downTo 0) {
      suf[i] = if (s[i] == '0') suf[i + 1] else min(suf[i + 1] + 2, n - i)
    }
    var ans: Int = MAX_VALUE
    for (i in 1..n) {
      ans = min(ans, pre[i] + suf[i])
    }
    return ans
  }
}
