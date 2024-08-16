internal class Solution {
  fun customSortString(order: String, s: String): String {
    val d = IntArray(26)
    for (i in 0 until order.length) {
      d[order[i].code - 'a'.code] = i
    }
    val cs: List<Char> = ArrayList()
    for (i in 0 until s.length) {
      cs.add(s[i])
    }
    cs.sort { a, b -> d[a - 'a'] - d[b - 'a'] }
    return cs.stream().map(java.lang.String::valueOf).collect(Collectors.joining())
  }
}
