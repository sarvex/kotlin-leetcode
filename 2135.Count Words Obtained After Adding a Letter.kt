internal class Solution {
  fun wordCount(startWords: Array<String>, targetWords: Array<String>): Int {
    val s: Set<Int> = HashSet()
    for (w in startWords) {
      var x = 0
      for (c in w.toCharArray()) {
        x = x or (1 shl (c.code - 'a'.code))
      }
      s.add(x)
    }
    var ans = 0
    for (w in targetWords) {
      var x = 0
      for (c in w.toCharArray()) {
        x = x or (1 shl (c.code - 'a'.code))
      }
      for (c in w.toCharArray()) {
        if (s.contains(x xor (1 shl (c.code - 'a'.code)))) {
          ++ans
          break
        }
      }
    }
    return ans
  }
}
