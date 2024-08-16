internal class Solution {
  fun findLexSmallestString(s: String, a: Int, b: Int): String {
    var s = s
    val q: Deque<String> = ArrayDeque()
    q.offer(s)
    val vis: Set<String> = HashSet()
    vis.add(s)
    var ans = s
    val n = s.length
    while (!q.isEmpty()) {
      s = q.poll()
      if (ans.compareTo(s) > 0) {
        ans = s
      }
      val cs: CharArray = s.toCharArray()
      var i = 1
      while (i < n) {
        cs[i] = (((cs[i].code - '0'.code + a) % 10) + '0'.code).toChar()
        i += 2
      }
      val t1 = String(cs)
      val t2: String = s.substring(n - b) + s.substring(0, n - b)
      for (t in List.of(t1, t2)) {
        if (vis.add(t)) {
          q.offer(t)
        }
      }
    }
    return ans
  }
}
