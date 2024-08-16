internal class Solution {
  fun findSubstringInWraproundString(s: String): Int {
    val f = IntArray(26)
    val n = s.length
    var i = 0
    var k = 0
    while (i < n) {
      if (i > 0 && (s[i].code - s[i - 1].code + 26) % 26 == 1) {
        ++k
      } else {
        k = 1
      }
      f[s[i].code - 'a'.code] = max(f[s[i].code - 'a'.code], k)
      ++i
    }
    return Arrays.stream(f).sum()
  }
}
