internal class Solution {
  fun reverseStr(s: String, k: Int): String {
    val cs: CharArray = s.toCharArray()
    val n = cs.size
    var i = 0
    while (i < n) {
      var l = i
      var r: Int = min(i + k - 1, n - 1)
      while (l < r) {
        val t = cs[l]
        cs[l] = cs[r]
        cs[r] = t
        ++l
        --r
      }
      i += k * 2
    }
    return String(cs)
  }
}
