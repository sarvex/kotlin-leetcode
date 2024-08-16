internal class Solution {
  fun largestVariance(s: String): Int {
    val n = s.length
    var ans = 0
    var a = 'a'
    while (a <= 'z') {
      var b = 'a'
      while (b <= 'z') {
        if (a == b) {
          ++b
          continue
        }
        val f = intArrayOf(0, -n)
        for (i in 0 until n) {
          if (s[i] == a) {
            f[0]++
            f[1]++
          } else if (s[i] == b) {
            f[1] = max(f[0] - 1, f[1] - 1)
            f[0] = 0
          }
          ans = max(ans, f[1])
        }
        ++b
      }
      ++a
    }
    return ans
  }
}
