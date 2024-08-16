internal class Solution {
  fun longestNiceSubstring(s: String): String {
    val n = s.length
    var k = -1
    var mx = 0
    for (i in 0 until n) {
      val ss: Set<Char> = HashSet()
      for (j in i until n) {
        ss.add(s[j])
        var ok = true
        for (a in ss) {
          val b: Char = (a.code xor 32).toChar()
          if (!(ss.contains(a) && ss.contains(b))) {
            ok = false
            break
          }
        }
        if (ok && mx < j - i + 1) {
          mx = j - i + 1
          k = i
        }
      }
    }
    return if (k == -1) "" else s.substring(k, k + mx)
  }
}
