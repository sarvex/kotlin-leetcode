internal class Solution {
  fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var l = 1
    var r = 1e9.toInt()
    while (l < r) {
      val mid = (l + r) shr 1
      var s = 0
      for (x in piles) {
        s += (x + mid - 1) / mid
      }
      if (s <= h) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
