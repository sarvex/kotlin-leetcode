import java.util.*

internal class Solution {
  fun longestIdealString(s: String, k: Int): Int {
    val n = s.length
    var ans = 1
    val dp = IntArray(n)
    Arrays.fill(dp, 1)
    val d: Map<Char, Int> = HashMap(26)
    d.put(s[0], 0)
    for (i in 1 until n) {
      val a = s[i]
      var b = 'a'
      while (b <= 'z') {
        if (abs(a.code - b.code) > k) {
          ++b
          continue
        }
        if (d.containsKey(b)) {
          dp[i] = max(dp[i], dp[d[b]!!] + 1)
        }
        ++b
      }
      d.put(a, i)
      ans = max(ans, dp[i])
    }
    return ans
  }
}
