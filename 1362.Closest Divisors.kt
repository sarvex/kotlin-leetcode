internal class Solution {
  fun closestDivisors(num: Int): IntArray {
    val a = f(num + 1)
    val b = f(num + 2)
    return if (abs(a[0] - a[1]) < abs(b[0] - b[1])) a else b
  }

  private fun f(x: Int): IntArray {
    var i = sqrt(x) as Int
    while (true) {
      if (x % i == 0) {
        return intArrayOf(i, x / i)
      }
      --i
    }
  }
}
