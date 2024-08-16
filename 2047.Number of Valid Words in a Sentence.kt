internal class Solution {
  fun countValidWords(sentence: String): Int {
    var ans = 0
    for (s in sentence.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
      ans += check(s.toCharArray())
    }
    return ans
  }

  private fun check(s: CharArray): Int {
    if (s.size == 0) {
      return 0
    }
    var st = false
    for (i in s.indices) {
      if (Character.isDigit(s[i])) {
        return 0
      }
      if ((s[i] == '!' || s[i] == '.' || s[i] == ',') && i < s.size - 1) {
        return 0
      }
      if (s[i] == '-') {
        if (st || i == 0 || i == s.size - 1) {
          return 0
        }
        if (!Character.isAlphabetic(s[i - 1].code) || !Character.isAlphabetic(s[i + 1].code)) {
          return 0
        }
        st = true
      }
    }
    return 1
  }
}
