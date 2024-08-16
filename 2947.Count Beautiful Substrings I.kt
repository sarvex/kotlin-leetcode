internal class Solution {
  fun beautifulSubstrings(s: String, k: Int): Int {
    val n = s.length
    val vs = IntArray(26)
    for (c in "aeiou".toCharArray()) {
      vs[c.code - 'a'.code] = 1
    }
    var ans = 0
    for (i in 0 until n) {
      var vowels = 0
      for (j in i until n) {
        vowels += vs[s[j].code - 'a'.code]
        val consonants: Int = j - i + 1 - vowels
        if (vowels == consonants && vowels * consonants % k == 0) {
          ++ans
        }
      }
    }
    return ans
  }
}
