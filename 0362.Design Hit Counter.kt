internal class HitCounter {
  private val ts: List<Int> = ArrayList()

  fun hit(timestamp: Int) {
    ts.add(timestamp)
  }

  fun getHits(timestamp: Int): Int {
    val l = search(timestamp - 300 + 1)
    return ts.size() - l
  }

  private fun search(x: Int): Int {
    var l = 0
    var r: Int = ts.size()
    while (l < r) {
      val mid = (l + r) shr 1
      if (ts[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
