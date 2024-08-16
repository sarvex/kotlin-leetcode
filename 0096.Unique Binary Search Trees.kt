internal class Solution {
  fun numTrees(n: Int): Int {
    val f = IntArray(n + 1)
    f[0] = 1
    for (i in 1..n) {
      for (j in 0 until i) {
        f[i] += f[j] * f[i - j - 1]
      }
    }
    return f[n]
  }
}
