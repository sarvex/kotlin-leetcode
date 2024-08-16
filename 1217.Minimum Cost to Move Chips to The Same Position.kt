internal class Solution {
  fun minCostToMoveChips(position: IntArray): Int {
    var a = 0
    for (p in position) {
      a += p % 2
    }
    val b = position.size - a
    return min(a, b)
  }
}
