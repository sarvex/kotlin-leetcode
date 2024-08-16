import java.util.*

internal class Solution {
  fun maxPrice(items: Array<IntArray>, capacity: Int): Double {
    var capacity = capacity
    Arrays.sort(items) { a, b -> a[1] * b[0] - a[0] * b[1] }
    var ans = 0.0
    for (e in items) {
      val p = e[0]
      val w = e[1]
      val v: Int = min(w, capacity)
      ans += v * 1.0 / w * p
      capacity -= v
    }
    return if (capacity > 0) -1.0 else ans
  }
}
