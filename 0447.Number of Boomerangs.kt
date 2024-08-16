internal class Solution {
  fun numberOfBoomerangs(points: Array<IntArray>): Int {
    var ans = 0
    for (p1 in points) {
      val cnt: Map<Int, Int> = HashMap()
      for (p2 in points) {
        val d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])
        ans += cnt.getOrDefault(d, 0)
        cnt.merge(d, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    return ans shl 1
  }
}
