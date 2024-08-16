import java.util.*

internal class Solution {
  fun maxPalindromesAfterOperations(words: Array<String>): Int {
    var s = 0
    var mask = 0
    for (w in words) {
      s += w.length
      for (c in w.toCharArray()) {
        mask = mask xor (1 shl (c.code - 'a'.code))
      }
    }
    s -= Integer.bitCount(mask)
    Arrays.sort(words) { a, b -> a.length() - b.length() }
    var ans = 0
    for (w in words) {
      s -= w.length / 2 * 2
      if (s < 0) {
        break
      }
      ++ans
    }
    return ans
  }
}
