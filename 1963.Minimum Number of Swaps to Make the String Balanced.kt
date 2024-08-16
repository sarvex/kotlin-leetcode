internal class Solution {
  fun minSwaps(s: String): Int {
    var x = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (c == '[') {
        ++x
      } else if (x > 0) {
        --x
      }
    }
    return (x + 1) / 2
  }
}
