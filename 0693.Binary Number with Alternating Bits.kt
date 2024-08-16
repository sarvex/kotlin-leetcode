internal class Solution {
  fun hasAlternatingBits(n: Int): Boolean {
    var n = n
    var prev = -1
    while (n != 0) {
      val curr = n and 1
      if (prev == curr) {
        return false
      }
      prev = curr
      n = n shr 1
    }
    return true
  }
}
