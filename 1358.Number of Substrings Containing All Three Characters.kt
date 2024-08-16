internal class Solution {
  fun numberOfSubstrings(s: String): Int {
    val d = intArrayOf(-1, -1, -1)
    var ans = 0
    for (i in 0 until s.length) {
      val c = s[i]
      d[c.code - 'a'.code] = i
      ans += min(d[0], min(d[1], d[2])) + 1
    }
    return ans
  }
}
