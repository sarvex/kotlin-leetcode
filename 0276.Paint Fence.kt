internal class Solution {
  fun numWays(n: Int, k: Int): Int {
    val f = IntArray(n)
    val g = IntArray(n)
    f[0] = k
    for (i in 1 until n) {
      f[i] = (f[i - 1] + g[i - 1]) * (k - 1)
      g[i] = f[i - 1]
    }
    return f[n - 1] + g[n - 1]
  }
}
