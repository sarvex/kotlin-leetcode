internal class Solution {
  fun minimumDistance(points: Array<IntArray>): Int {
    val tm1: TreeMap<Int, Int> = TreeMap()
    val tm2: TreeMap<Int, Int> = TreeMap()
    for (p in points) {
      val x = p[0]
      val y = p[1]
      tm1.merge(x + y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      tm2.merge(x - y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans: Int = MAX_VALUE
    for (p in points) {
      val x = p[0]
      val y = p[1]
      if (tm1.merge(x + y, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        tm1.remove(x + y)
      }
      if (tm2.merge(x - y, -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        tm2.remove(x - y)
      }
      ans = Math.min(
        ans, Math.max(tm1.lastKey() - tm1.firstKey(), tm2.lastKey() - tm2.firstKey())
      )
      tm1.merge(x + y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      tm2.merge(x - y, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
