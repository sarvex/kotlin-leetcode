internal class Solution {
  fun makeSmallestPalindrome(s: String): String {
    val cs: CharArray = s.toCharArray()
    var i = 0
    var j = cs.size - 1
    while (i < j) {
      cs[j] = min(cs[i], cs[j]) as Char
      cs[i] = cs[j]
      ++i
      --j
    }
    return String(cs)
  }
}
