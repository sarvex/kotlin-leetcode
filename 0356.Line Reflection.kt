internal class Solution {
  fun isReflected(points: Array<IntArray>): Boolean {
    val inf = 1 shl 30
    var minX = inf
    var maxX = -inf
    val pointSet: Set<List<Int>> = HashSet()
    for (p in points) {
      minX = min(minX, p[0])
      maxX = max(maxX, p[0])
      pointSet.add(List.of(p[0], p[1]))
    }
    val s = minX + maxX
    for (p in points) {
      if (!pointSet.contains(List.of(s - p[0], p[1]))) {
        return false
      }
    }
    return true
  }
}
