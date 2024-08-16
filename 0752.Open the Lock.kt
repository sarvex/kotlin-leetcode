import java.util.Deque

internal class Solution {
  fun openLock(deadends: Array<String?>?, target: String): Int {
    if ("0000" == target) {
      return 0
    }
    val s: Set<String> = HashSet(Arrays.asList(deadends))
    if (s.contains("0000")) {
      return -1
    }
    val q: Deque<String> = ArrayDeque()
    q.offer("0000")
    s.add("0000")
    var ans = 0
    while (!q.isEmpty()) {
      ++ans
      for (n in q.size() downTo 1) {
        val p = q.poll()
        for (t in next(p)) {
          if (target == t) {
            return ans
          }
          if (!s.contains(t)) {
            q.offer(t)
            s.add(t)
          }
        }
      }
    }
    return -1
  }

  private fun next(t: String): List<String> {
    val res: List = ArrayList()
    val chars: CharArray = t.toCharArray()
    for (i in 0..3) {
      val c = chars[i]
      chars[i] = if (c == '0') '9' else (c.code - 1).toChar()
      res.add(String(chars))
      chars[i] = if (c == '9') '0' else (c.code + 1).toChar()
      res.add(String(chars))
      chars[i] = c
    }
    return res
  }
}
