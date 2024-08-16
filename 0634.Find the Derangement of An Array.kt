internal class Solution {
  fun findDerangement(n: Int): Int {
    val f = LongArray(n + 1)
    f[0] = 1
    val mod = 1e9.toInt() + 7
    for (i in 2..n) {
      f[i] = (i - 1) * (f[i - 1] + f[i - 2]) % mod
    }
    return f[n].toInt()
  }
}
