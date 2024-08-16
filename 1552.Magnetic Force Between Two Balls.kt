internal class Solution {
  private var position: IntArray

  fun maxDistance(position: IntArray, m: Int): Int {
    Arrays.sort(position)
    this.position = position
    var l = 1
    var r = position[position.size - 1]
    while (l < r) {
      val mid = (l + r + 1) shr 1
      if (count(mid) >= m) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun count(f: Int): Int {
    var prev = position[0]
    var cnt = 1
    for (curr in position) {
      if (curr - prev >= f) {
        ++cnt
        prev = curr
      }
    }
    return cnt
  }
}
