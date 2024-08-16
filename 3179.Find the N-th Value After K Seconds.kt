import java.util.*

internal class Solution {
  fun valueAfterKSeconds(n: Int, k: Int): Int {
    var k = k
    val mod = 1e9.toInt() + 7
    val a = IntArray(n)
    Arrays.fill(a, 1)
    while (k-- > 0) {
      for (i in 1 until n) {
        a[i] = (a[i] + a[i - 1]) % mod
      }
    }
    return a[n - 1]
  }
}
