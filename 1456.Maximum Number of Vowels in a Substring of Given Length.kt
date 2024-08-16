internal class Solution {
  fun maxVowels(s: String, k: Int): Int {
    var cnt = 0
    for (i in 0 until k) {
      if (isVowel(s[i])) {
        ++cnt
      }
    }
    var ans = cnt
    for (i in k until s.length) {
      if (isVowel(s[i])) {
        ++cnt
      }
      if (isVowel(s[i - k])) {
        --cnt
      }
      ans = max(ans, cnt)
    }
    return ans
  }

  private fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
  }
}
