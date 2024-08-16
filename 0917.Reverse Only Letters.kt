internal class Solution {
  fun reverseOnlyLetters(s: String): String {
    val cs: CharArray = s.toCharArray()
    var i = 0
    var j = cs.size - 1
    while (i < j) {
      while (i < j && !Character.isLetter(cs[i])) {
        ++i
      }
      while (i < j && !Character.isLetter(cs[j])) {
        --j
      }
      if (i < j) {
        val t = cs[i]
        cs[i] = cs[j]
        cs[j] = t
        ++i
        --j
      }
    }
    return String(cs)
  }
}
