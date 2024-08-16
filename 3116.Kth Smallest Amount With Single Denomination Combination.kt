internal class Solution {
  private var coins: IntArray
  private var k = 0

  fun findKthSmallest(coins: IntArray, k: Int): Long {
    this.coins = coins
    this.k = k
    var l: Long = 1
    var r = 1e11.toLong()
    while (l < r) {
      val mid = (l + r) shr 1
      if (check(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun check(mx: Long): Boolean {
    var cnt: Long = 0
    val n = coins.size
    for (i in 1 until (1 shl n)) {
      var v: Long = 1
      for (j in 0 until n) {
        if ((i shr j and 1) == 1) {
          v = lcm(v, coins[j].toLong())
          if (v > mx) {
            break
          }
        }
      }
      val m = Integer.bitCount(i)
      if (m % 2 == 1) {
        cnt += mx / v
      } else {
        cnt -= mx / v
      }
    }
    return cnt >= k
  }

  private fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
  }

  private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
  }
}
