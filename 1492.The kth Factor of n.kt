internal class Solution {
  fun kthFactor(n: Int, k: Int): Int {
    var k = k
    for (i in 1..n) {
      if (n % i == 0 && (--k == 0)) {
        return i
      }
    }
    return -1
  }
}
