internal class Solution {
  fun subsequenceCount(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    var f = IntArray(2)
    for (x in nums) {
      val g = IntArray(2)
      if (x % 2 == 1) {
        g[0] = (f[0] + f[1]) % mod
        g[1] = (f[0] + f[1] + 1) % mod
      } else {
        g[0] = (f[0] + f[0] + 1) % mod
        g[1] = (f[1] + f[1]) % mod
      }
      f = g
    }
    return f[1]
  }
}
