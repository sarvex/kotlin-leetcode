internal class Solution {
  fun lastNonEmptyString(s: String): String {
    val cnt = IntArray(26)
    val last = IntArray(26)
    val n = s.length
    var mx = 0
    for (i in 0 until n) {
      val c: Int = s[i].code - 'a'.code
      mx = max(mx, ++cnt[c])
      last[c] = i
    }
    val ans = StringBuilder()
    for (i in 0 until n) {
      val c: Int = s[i].code - 'a'.code
      if (cnt[c] == mx && last[c] == i) {
        ans.append(s[i])
      }
    }
    return ans.toString()
  }
}
