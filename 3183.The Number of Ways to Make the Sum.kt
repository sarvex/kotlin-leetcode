internal class Solution {
  fun numberOfWays(n: Int): Int {
    val mod = 1e9.toInt() + 7
    val coins = intArrayOf(1, 2, 6)
    val f = IntArray(n + 1)
    f[0] = 1
    for (x in coins) {
      for (j in x..n) {
        f[j] = (f[j] + f[j - x]) % mod
      }
    }
    var ans = f[n]
    if (n >= 4) {
      ans = (ans + f[n - 4]) % mod
    }
    if (n >= 8) {
      ans = (ans + f[n - 8]) % mod
    }
    return ans
  }
}
