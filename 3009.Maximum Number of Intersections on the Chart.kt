internal class Solution {
  fun maxIntersectionCount(y: IntArray): Int {
    val n = y.size
    var ans = 0
    var intersectionCount = 0
    val line: TreeMap<Int, Int> = TreeMap()

    for (i in 1 until n) {
      val start = 2 * y[i - 1]
      val end = 2 * y[i] + (if (i == n - 1) 0 else if (y[i] > y[i - 1]) -1 else 1)
      line.merge(min(start, end), 1) { a: Int, b: Int -> Integer.sum(a, b) }
      line.merge(max(start, end) + 1, -1) { a: Int, b: Int -> Integer.sum(a, b) }
    }

    for (count in line.values()) {
      intersectionCount += count
      ans = max(ans, intersectionCount)
    }

    return ans
  }
}
