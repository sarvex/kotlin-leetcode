internal class Solution {
  fun getSmallestString(s: String, k: Int): String {
    var k = k
    val cs: CharArray = s.toCharArray()
    for (i in cs.indices) {
      val c1 = cs[i]
      var c2 = 'a'
      while (c2 < c1) {
        val d: Int = min(c1.code - c2.code, 26 - c1.code + c2.code)
        if (d <= k) {
          cs[i] = c2
          k -= d
          break
        }
        ++c2
      }
    }
    return String(cs)
  }
}
