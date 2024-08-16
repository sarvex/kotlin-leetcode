internal class Solution {
  fun kClosest(points: Array<IntArray?>?, k: Int): Array<IntArray> {
    Arrays.sort(
      points
    ) { p1, p2 -> if (hypot(p1.get(0), p1.get(1)) - hypot(p2.get(0), p2.get(1)) > 0) 1 else -1 }
    return Arrays.copyOfRange(points, 0, k)
  }
}
