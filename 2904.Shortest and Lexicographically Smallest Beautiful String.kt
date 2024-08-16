internal class Solution {
  fun shortestBeautifulSubstring(s: String, k: Int): String {
    val n = s.length
    var ans = ""
    for (i in 0 until n) {
      for (j in i + k..n) {
        val t: String = s.substring(i, j)
        var cnt = 0
        for (c in t.toCharArray()) {
          cnt += c.code - '0'.code
        }
        if (cnt == k
          && ("" == ans || j - i < ans.length || (j - i == ans.length && t.compareTo(ans) < 0))
        ) {
          ans = t
        }
      }
    }
    return ans
  }
}
