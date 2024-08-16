import java.util.*

internal class Solution {
  fun clearStars(s: String): String {
    val g: Array<Deque<Int>> = arrayOfNulls<Deque>(26)
    Arrays.setAll(g) { k -> ArrayDeque() }
    val n = s.length
    val rem = BooleanArray(n)
    for (i in 0 until n) {
      if (s[i] == '*') {
        rem[i] = true
        for (j in 0..25) {
          if (!g[j].isEmpty()) {
            rem[g[j].pop()] = true
            break
          }
        }
      } else {
        g[s[i].code - 'a'.code].push(i)
      }
    }
    val sb = StringBuilder()
    for (i in 0 until n) {
      if (!rem[i]) {
        sb.append(s[i])
      }
    }
    return sb.toString()
  }
}
