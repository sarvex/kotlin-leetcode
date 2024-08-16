import java.util.*

internal class Solution {
  fun minimumKeypresses(s: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    Arrays.sort(cnt)
    var ans = 0
    var k = 1
    for (i in 1..26) {
      ans += k * cnt[26 - i]
      if (i % 9 == 0) {
        ++k
      }
    }
    return ans
  }
}
