internal class Solution {
  fun minimumSwap(s1: String, s2: String): Int {
    var xy = 0
    var yx = 0
    for (i in 0 until s1.length) {
      val a = s1[i]
      val b = s2[i]
      if (a < b) {
        ++xy
      }
      if (a > b) {
        ++yx
      }
    }
    if ((xy + yx) % 2 == 1) {
      return -1
    }
    return xy / 2 + yx / 2 + xy % 2 + yx % 2
  }
}
