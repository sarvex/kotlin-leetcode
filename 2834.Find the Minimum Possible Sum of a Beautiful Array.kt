internal class Solution {
  fun minimumPossibleSum(n: Int, target: Int): Int {
    val mod = 1e9.toInt() + 7
    val m = target / 2
    if (n <= m) {
      return ((1L + n) * n / 2 % mod).toInt()
    }
    val a = (1L + m) * m / 2 % mod
    val b = ((1L * target + target + n - m - 1) * (n - m) / 2) % mod
    return ((a + b) % mod).toInt()
  }
}
