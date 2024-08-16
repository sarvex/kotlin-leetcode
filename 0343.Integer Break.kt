internal class Solution {
  fun integerBreak(n: Int): Int {
    val f = IntArray(n + 1)
    f[1] = 1
    for (i in 2..n) {
      for (j in 1 until i) {
        f[i] = max(max(f[i], f[i - j] * j), (i - j) * j)
      }
    }
    return f[n]
  }
}
