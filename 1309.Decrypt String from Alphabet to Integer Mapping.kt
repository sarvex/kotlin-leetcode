internal class Solution {
  fun freqAlphabets(s: String): String {
    var i = 0
    val n = s.length
    val res = StringBuilder()
    while (i < n) {
      if (i + 2 < n && s[i + 2] == '#') {
        res.append(get(s.substring(i, i + 2)))
        i += 3
      } else {
        res.append(get(s.substring(i, i + 1)))
        i += 1
      }
    }
    return res.toString()
  }

  private fun get(s: String): Char {
    return ('a' + s.toInt() - 1).toChar()
  }
}
