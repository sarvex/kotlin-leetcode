internal class Solution {
  fun toLowerCase(s: String): String {
    val cs: CharArray = s.toCharArray()
    for (i in cs.indices) {
      if (cs[i] >= 'A' && cs[i] <= 'Z') {
        cs[i] = cs[i].code or 32
      }
    }
    return String(cs)
  }
}
