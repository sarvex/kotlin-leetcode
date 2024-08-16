internal class Solution {
  fun isPrefixString(s: String, words: Array<String?>): Boolean {
    val t = StringBuilder()
    for (w in words) {
      t.append(w)
      if (t.length > s.length) {
        return false
      }
      if (t.length == s.length) {
        return s == t.toString()
      }
    }
    return false
  }
}
