internal class Solution {
  fun reverseWords(s: String): String {
    val words: List<String> = ArrayList()
    val n = s.length
    var i = 0
    while (i < n) {
      while (i < n && s[i] == ' ') {
        ++i
      }
      if (i < n) {
        val t = StringBuilder()
        var j = i
        while (j < n && s[j] != ' ') {
          t.append(s[j++])
        }
        words.add(t.toString())
        i = j
      }
    }
    Collections.reverse(words)
    return java.lang.String.join(" ", words)
  }
}
