internal class Solution {
  fun sortVowels(s: String): String {
    val vs: List<Char> = ArrayList()
    val cs: CharArray = s.toCharArray()
    for (c in cs) {
      val d: Char = c.lowercaseChar()
      if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
        vs.add(c)
      }
    }
    Collections.sort(vs)
    var i = 0
    var j = 0
    while (i < cs.size) {
      val d: Char = cs[i].lowercaseChar()
      if (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u') {
        cs[i] = vs[j++]
      }
      ++i
    }
    return String(cs)
  }
}
