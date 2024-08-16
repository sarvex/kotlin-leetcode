internal class Solution {
  fun isSubstringPresent(s: String): Boolean {
    val st = Array(26) { BooleanArray(26) }
    val n = s.length
    for (i in 0 until n - 1) {
      st[s[i + 1].code - 'a'.code][s[i].code - 'a'.code] = true
    }
    for (i in 0 until n - 1) {
      if (st[s[i].code - 'a'.code][s[i + 1].code - 'a'.code]) {
        return true
      }
    }
    return false
  }
}
