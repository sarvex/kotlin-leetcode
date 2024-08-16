import java.util.*

internal class Solution {
  fun minimumPushes(word: String): Int {
    val cnt = IntArray(26)
    for (i in 0 until word.length) {
      ++cnt[word[i].code - 'a'.code]
    }
    Arrays.sort(cnt)
    var ans = 0
    for (i in 0..25) {
      ans += (i / 8 + 1) * cnt[26 - i - 1]
    }
    return ans
  }
}
