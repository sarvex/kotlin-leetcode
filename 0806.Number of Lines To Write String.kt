internal class Solution {
  fun numberOfLines(widths: IntArray, s: String): IntArray {
    var lines = 1
    var last = 0
    for (i in 0 until s.length) {
      val w = widths[s[i].code - 'a'.code]
      if (last + w <= 100) {
        last += w
      } else {
        ++lines
        last = w
      }
    }
    return intArrayOf(lines, last)
  }
}
