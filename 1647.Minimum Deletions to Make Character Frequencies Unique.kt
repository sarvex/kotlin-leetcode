internal class Solution {
  fun minDeletions(s: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    Arrays.sort(cnt)
    var ans = 0
    for (i in 24 downTo 0) {
      while (cnt[i] >= cnt[i + 1] && cnt[i] > 0) {
        --cnt[i]
        ++ans
      }
    }
    return ans
  }
}
