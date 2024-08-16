internal class Solution {
  fun repeatedCharacter(s: String): Char {
    val cnt = IntArray(26)
    var i = 0
    while (true) {
      val c = s[i]
      if (++cnt[c.code - 'a'.code] == 2) {
        return c
      }
      ++i
    }
  }
}
