internal class Solution {
  fun countOfAtoms(formula: String): String {
    val map: Map<String, Int> = HashMap()
    val stack = IntArray(1000)
    var top = 0
    var multiplier = 1
    var freq = 0
    val c: CharArray = formula.toCharArray()
    var i = c.size - 1
    while (i >= 0) {
      if (c[i] >= 'a' && c[i] <= 'z') {
        val end = i--
        while (i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--
        val key = String(c, i, end - i + 1)
        map.put(key, map.getOrDefault(key, 0) + max(freq, 1) * multiplier)
        freq = 0
      } else if (c[i] >= 'A' && c[i] <= 'Z') {
        val key = String(c, i, 1)
        map.put(key, map.getOrDefault(key, 0) + max(freq, 1) * multiplier)
        freq = 0
      } else if (c[i] >= '0' && c[i] <= '9') {
        freq = c[i].code - '0'.code
        var p = 10
        while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
          freq += p * (c[--i].code - '0'.code)
          p *= 10
        }
      } else if (c[i] == ')') {
        stack[top++] = multiplier
        multiplier *= max(freq, 1)
        freq = 0
      } else {
        multiplier = stack[--top]
      }
      i--
    }
    val keys: List<String> = ArrayList(map.keySet())
    Collections.sort(keys)
    val sb = StringBuilder()
    for (key in keys) {
      sb.append(key)
      val f = map[key]!!
      if (f > 1) sb.append(f)
    }
    return sb.toString()
  }
}
