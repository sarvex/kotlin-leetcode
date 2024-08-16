internal class Solution {
  fun minimumLength(s: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    var ans = 0
    for (x in cnt) {
      if (x > 0) {
        ans += if (x % 2 == 1) 1 else 2
      }
    }
    return ans
  }
}
