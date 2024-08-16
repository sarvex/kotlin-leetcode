import java.util.*

internal class Solution {
  fun maximumBags(capacity: IntArray, rocks: IntArray, additionalRocks: Int): Int {
    var additionalRocks = additionalRocks
    val n = rocks.size
    for (i in 0 until n) {
      capacity[i] -= rocks[i]
    }
    Arrays.sort(capacity)
    for (i in 0 until n) {
      additionalRocks -= capacity[i]
      if (additionalRocks < 0) {
        return i
      }
    }
    return n
  }
}
