internal class Solution {
  fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
    val g: TreeMap<Int, List<Int>> = TreeMap()
    for (i in points.indices) {
      val x = points[i][0]
      val y = points[i][1]
      val key: Int = max(abs(x), abs(y))
      g.computeIfAbsent(key) { k -> ArrayList() }.add(i)
    }
    val vis = BooleanArray(26)
    var ans = 0
    for (idx in g.values()) {
      for (i in idx) {
        val j: Int = s[i].code - 'a'.code
        if (vis[j]) {
          return ans
        }
        vis[j] = true
      }
      ans += idx.size()
    }
    return ans
  }
}
