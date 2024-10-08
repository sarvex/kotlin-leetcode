internal class Solution {
  fun maxRepOpt1(text: String): Int {
    val cnt = IntArray(26)
    val n = text.length
    for (i in 0 until n) {
      ++cnt[text[i].code - 'a'.code]
    }
    var ans = 0
    var i = 0
    while (i < n) {
      var j = i
      while (j < n && text[j] == text[i]) {
        ++j
      }
      val l = j - i
      var k = j + 1
      while (k < n && text[k] == text[i]) {
        ++k
      }
      val r = k - j - 1
      ans = max(ans, min(l + r + 1, cnt[text[i].code - 'a'.code]))
      i = j
    }
    return ans
  }
}
