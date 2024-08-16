import java.util.*

internal class Solution {
  fun minimizeStringValue(s: String): String {
    val cnt = IntArray(26)
    val n = s.length
    var k = 0
    val cs: CharArray = s.toCharArray()
    for (c in cs) {
      if (c == '?') {
        ++k
      } else {
        ++cnt[c.code - 'a'.code]
      }
    }
    val pq
        : PriorityQueue<IntArray> = PriorityQueue { a, b ->
      if (a.get(0) === b.get(0)) a.get(1) - b.get(1) else a.get(0) - b.get(
        0
      )
    }
    for (i in 0..25) {
      pq.offer(intArrayOf(cnt[i], i))
    }
    val t = IntArray(k)
    for (j in 0 until k) {
      val p: IntArray = pq.poll()
      t[j] = p[1]
      pq.offer(intArrayOf(p[0] + 1, p[1]))
    }
    Arrays.sort(t)

    var i = 0
    var j = 0
    while (i < n) {
      if (cs[i] == '?') {
        cs[i] = (t[j++] + 'a'.code).toChar()
      }
      ++i
    }
    return String(cs)
  }
}
