internal class Solution {
  fun minimumDeletions(s: String): Int {
    val n = s.length
    val f = IntArray(n + 1)
    var b = 0
    for (i in 1..n) {
      if (s[i - 1] == 'b') {
        f[i] = f[i - 1]
        ++b
      } else {
        f[i] = min(f[i - 1] + 1, b)
      }
    }
    return f[n]
  }
}
