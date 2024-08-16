internal class Solution {
  fun numberOfArrays(differences: IntArray, lower: Int, upper: Int): Int {
    var num: Long = 0
    var mi: Long = 0
    var mx: Long = 0
    for (d in differences) {
      num += d.toLong()
      mi = min(mi, num)
      mx = max(mx, num)
    }
    return max(0, (upper - lower - (mx - mi) + 1).toInt())
  }
}
