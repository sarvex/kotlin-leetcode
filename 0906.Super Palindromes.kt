internal class Solution {
  fun superpalindromesInRange(left: String, right: String): Int {
    val l: Long = left.toLong()
    val r: Long = right.toLong()
    var ans = 0
    for (p in Solution.Companion.ps) {
      val x = p * p
      if (x >= l && x <= r && isPalindrome(x)) {
        ++ans
      }
    }
    return ans
  }

  private fun isPalindrome(x: Long): Boolean {
    var y: Long = 0
    var t = x
    while (t > 0) {
      y = y * 10 + t % 10
      t /= 10
    }
    return x == y
  }

  companion object {
    private val ps: LongArray

    init {
      Solution.Companion.ps = LongArray(2 * 1e5.toInt())
      var i = 1
      while (i <= 1e5) {
        val s = i.toString()
        val t1 = StringBuilder(s).reverse().toString()
        val t2: String = StringBuilder(s.substring(0, s.length - 1)).reverse().toString()
        Solution.Companion.ps.get(2 * i - 2) = (s + t1).toLong()
        Solution.Companion.ps.get(2 * i - 1) = (s + t2).toLong()
        i++
      }
    }
  }
}
