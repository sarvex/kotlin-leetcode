internal class Solution {
  fun numberOfSpecialChars(word: String): Int {
    val s = BooleanArray('z'.code + 1)
    for (i in 0 until word.length) {
      s[word[i].code] = true
    }
    var ans = 0
    for (i in 0..25) {
      if (s['a'.code + i] && s['A'.code + i]) {
        ++ans
      }
    }
    return ans
  }
}
