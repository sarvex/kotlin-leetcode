internal class Solution {
  fun isThree(n: Int): Boolean {
    var cnt = 0
    for (i in 2 until n) {
      if (n % i == 0) {
        ++cnt
      }
    }
    return cnt == 1
  }
}
