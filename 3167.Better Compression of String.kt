internal class Solution {
  fun betterCompression(compressed: String): String {
    val cnt: Map<Char, Int> = TreeMap()
    var i = 0
    val n = compressed.length
    while (i < n) {
      val c = compressed[i]
      var j = i + 1
      var x = 0
      while (j < n && Character.isDigit(compressed[j])) {
        x = x * 10 + (compressed[j].code - '0'.code)
        j++
      }
      cnt.merge(c, x) { a: Int, b: Int -> Integer.sum(a, b) }
      i = j
    }
    val ans = StringBuilder()
    for (e in cnt.entrySet()) {
      ans.append(e.getKey()).append(e.getValue())
    }
    return ans.toString()
  }
}
