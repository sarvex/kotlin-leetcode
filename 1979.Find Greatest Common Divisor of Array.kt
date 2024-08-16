internal class Solution {
  fun findGCD(nums: IntArray): Int {
    var a = 1
    var b = 1000
    for (x in nums) {
      a = max(a, x)
      b = min(b, x)
    }
    return gcd(a, b)
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
