internal class Solution {
  fun replaceNonCoprimes(nums: IntArray): List<Int> {
    val stk: List<Int> = ArrayList()
    for (x in nums) {
      var x = x
      stk.add(x)
      while (stk.size() > 1) {
        x = stk[stk.size() - 1]
        val y = stk[stk.size() - 2]
        val g = gcd(x, y)
        if (g == 1) {
          break
        }
        stk.remove(stk.size() - 1)
        stk.set(stk.size() - 1, (x.toLong() * y / g).toInt())
      }
    }
    return stk
  }

  private fun gcd(a: Int, b: Int): Int {
    if (b == 0) {
      return a
    }
    return gcd(b, a % b)
  }
}
