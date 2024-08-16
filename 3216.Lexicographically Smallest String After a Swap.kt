internal class Solution {
  fun getSmallestString(s: String): String {
    val cs: CharArray = s.toCharArray()
    val n = cs.size
    for (i in 1 until n) {
      val a = cs[i - 1]
      val b = cs[i]
      if (a > b && a.code % 2 == b.code % 2) {
        cs[i] = a
        cs[i - 1] = b
        return String(cs)
      }
    }
    return s
  }
}
