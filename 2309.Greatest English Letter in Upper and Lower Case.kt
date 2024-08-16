internal class Solution {
  fun greatestLetter(s: String): String {
    val ss: Set<Char> = HashSet()
    for (c in s.toCharArray()) {
      ss.add(c)
    }
    var a = 'Z'
    while (a >= 'A') {
      if (ss.contains(a) && ss.contains((a.code + 32).toChar())) {
        return a.toString()
      }
      --a
    }
    return ""
  }
}
