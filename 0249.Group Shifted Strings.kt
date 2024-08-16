internal class Solution {
  fun groupStrings(strings: Array<String>): List<List<String>> {
    val g: Map<String, List<String>> = HashMap()
    for (s in strings) {
      val t: CharArray = s.toCharArray()
      val diff: Int = t[0].code - 'a'.code
      for (i in t.indices) {
        t[i] = (t[i].code - diff).toChar()
        if (t[i] < 'a') {
          t[i] += 26.toChar().code
        }
      }
      g.computeIfAbsent(String(t)) { k -> ArrayList() }.add(s)
    }
    return ArrayList(g.values())
  }
}
