internal class Solution {
  fun countVowelPermutation(n: Int): Int {
    var f = LongArray(5)
    Arrays.fill(f, 1)
    val mod = 1e9.toInt() + 7
    for (i in 1 until n) {
      val g = LongArray(5)
      g[0] = (f[1] + f[2] + f[4]) % mod
      g[1] = (f[0] + f[2]) % mod
      g[2] = (f[1] + f[3]) % mod
      g[3] = f[2]
      g[4] = (f[2] + f[3]) % mod
      f = g
    }
    var ans: Long = 0
    for (x in f) {
      ans = (ans + x) % mod
    }
    return ans.toInt()
  }
}
