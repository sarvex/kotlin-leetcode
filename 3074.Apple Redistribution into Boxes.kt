import java.util.*

internal class Solution {
  fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    Arrays.sort(capacity)
    var s = 0
    for (x in apple) {
      s += x
    }
    var i = 1
    val n = capacity.size
    while (true) {
      s -= capacity[n - i]
      if (s <= 0) {
        return i
      }
      ++i
    }
  }
}
