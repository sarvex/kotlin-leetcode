import java.util.*

internal class Solution {
  fun countWays(ranges: Array<IntArray>): Int {
    Arrays.sort(ranges) { a, b -> a[0] - b[0] }
    var cnt = 0
    var mx = -1
    for (e in ranges) {
      if (e[0] > mx) {
        ++cnt
      }
      mx = max(mx, e[1])
    }
    return qpow(2, cnt, 1e9.toInt() + 7)
  }

  private fun qpow(a: Long, n: Int, mod: Int): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if ((n and 1) == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
