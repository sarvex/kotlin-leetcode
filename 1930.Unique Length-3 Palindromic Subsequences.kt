internal class Solution {
  fun countPalindromicSubsequence(s: String): Int {
    var ans = 0
    var c = 'a'
    while (c <= 'z') {
      val l: Int = s.indexOf(c)
      val r: Int = s.lastIndexOf(c)
      val cs: Set<Char> = HashSet()
      for (i in l + 1 until r) {
        cs.add(s[i])
      }
      ans += cs.size()
      ++c
    }
    return ans
  }
}
