internal class Solution {
  fun longestPalindrome(s: String): Int {
    val cnt = IntArray(128)
    val n = s.length
    for (i in 0 until n) {
      ++cnt[s[i].code]
    }
    var ans = 0
    for (v in cnt) {
      ans += v / 2 * 2
    }
    ans += if (ans < n) 1 else 0
    return ans
  }
}
