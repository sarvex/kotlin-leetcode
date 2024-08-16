internal class Solution {
  fun commonFactors(a: Int, b: Int): Int {
    val g = gcd(a, b)
    var ans = 0
    for (x in 1..g) {
      if (g % x == 0) {
        ++ans
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
