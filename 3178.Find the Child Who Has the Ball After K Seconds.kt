internal class Solution {
  fun numberOfChild(n: Int, k: Int): Int {
    var k = k
    val mod = k % (n - 1)
    k /= (n - 1)
    return if (k % 2 == 1) n - mod - 1 else mod
  }
}
