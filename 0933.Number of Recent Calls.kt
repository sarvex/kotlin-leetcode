internal class RecentCounter {
  private val s = IntArray(10010)
  private var idx = 0

  fun ping(t: Int): Int {
    s[idx++] = t
    return idx - search(t - 3000)
  }

  private fun search(x: Int): Int {
    var left = 0
    var right = idx
    while (left < right) {
      val mid = (left + right) shr 1
      if (s[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
