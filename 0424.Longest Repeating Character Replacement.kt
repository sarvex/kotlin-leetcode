internal class Solution {
  fun characterReplacement(s: String, k: Int): Int {
    val cnt = IntArray(26)
    var l = 0
    var mx = 0
    val n = s.length
    for (r in 0 until n) {
      mx = max(mx, ++cnt[s[r].code - 'A'.code])
      if (r - l + 1 - mx > k) {
        --cnt[s[l++].code - 'A'.code]
      }
    }
    return n - l
  }
}
