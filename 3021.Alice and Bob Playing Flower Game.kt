internal class Solution {
  fun flowerGame(n: Int, m: Int): Long {
    val a1 = ((n + 1) / 2).toLong()
    val b1 = ((m + 1) / 2).toLong()
    val a2 = (n / 2).toLong()
    val b2 = (m / 2).toLong()
    return a1 * b2 + a2 * b1
  }
}
