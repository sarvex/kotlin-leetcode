import java.util.*

internal class Solution {
  fun maxSubstringLength(s: String): Int {
    val first = IntArray(26)
    val last = IntArray(26)
    Arrays.fill(first, -1)
    val n = s.length
    for (i in 0 until n) {
      val j: Int = s[i].code - 'a'.code
      if (first[j] == -1) {
        first[j] = i
      }
      last[j] = i
    }
    var ans = -1
    for (k in 0..25) {
      val i = first[k]
      if (i == -1) {
        continue
      }
      var mx = last[k]
      for (j in i until n) {
        val a = first[s[j].code - 'a'.code]
        val b = last[s[j].code - 'a'.code]
        if (a < i) {
          break
        }
        mx = max(mx, b)
        if (mx == j && j - i + 1 < n) {
          ans = max(ans, j - i + 1)
        }
      }
    }
    return ans
  }
}
