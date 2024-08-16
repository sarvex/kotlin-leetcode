import java.util.Deque

internal class Solution {
  fun numMatchingSubseq(s: String, words: Array<String>): Int {
    val d: Array<Deque<String>> = arrayOfNulls(26)
    Arrays.setAll(d) { k -> ArrayDeque() }
    for (w in words) {
      d[w[0].code - 'a'.code].add(w)
    }
    var ans = 0
    for (c in s.toCharArray()) {
      val q = d[c.code - 'a'.code]
      for (k in q.size() downTo 1) {
        val t = q.pollFirst()
        if (t.length == 1) {
          ++ans
        } else {
          d[t[1].code - 'a'.code].offer(t.substring(1))
        }
      }
    }
    return ans
  }
}
