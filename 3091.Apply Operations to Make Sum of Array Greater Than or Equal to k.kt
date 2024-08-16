internal class Solution {
  fun minOperations(k: Int): Int {
    var ans = k
    for (a in 0 until k) {
      val x: Int = a + 1
      val b = (k + x - 1) / x - 1
      ans = min(ans, a + b)
    }
    return ans
  }
}
