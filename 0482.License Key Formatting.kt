internal class Solution {
  fun licenseKeyFormatting(s: String, k: Int): String {
    val n = s.length
    var cnt = (n - s.chars().filter { ch: Int -> ch == '-'.code }.count()).toInt() % k
    if (cnt == 0) {
      cnt = k
    }
    val ans = StringBuilder()
    for (i in 0 until n) {
      val c = s[i]
      if (c == '-') {
        continue
      }
      ans.append(c.uppercaseChar())
      --cnt
      if (cnt == 0) {
        cnt = k
        if (i != n - 1) {
          ans.append('-')
        }
      }
    }
    if (ans.length > 0 && ans[ans.length - 1] == '-') {
      ans.deleteCharAt(ans.length - 1)
    }
    return ans.toString()
  }
}
