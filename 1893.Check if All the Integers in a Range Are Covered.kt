internal class Solution {
  fun isCovered(ranges: Array<IntArray>, left: Int, right: Int): Boolean {
    val diff = IntArray(52)
    for (range in ranges) {
      val l = range[0]
      val r = range[1]
      ++diff[l]
      --diff[r + 1]
    }
    var s = 0
    for (i in diff.indices) {
      s += diff[i]
      if (s <= 0 && left <= i && i <= right) {
        return false
      }
    }
    return true
  }
}
