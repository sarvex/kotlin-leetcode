internal class Solution {
  fun isSelfCrossing(distance: IntArray): Boolean {
    val d = distance
    for (i in 3 until d.size) {
      if (d[i] >= d[i - 2] && d[i - 1] <= d[i - 3]) {
        return true
      }
      if (i >= 4 && d[i - 1] == d[i - 3] && d[i] + d[i - 4] >= d[i - 2]) {
        return true
      }
      if (i >= 5 && d[i - 2] >= d[i - 4] && d[i - 1] <= d[i - 3] && d[i] >= d[i - 2] - d[i - 4] && d[i - 1] + d[i - 5] >= d[i - 3]) {
        return true
      }
    }
    return false
  }
}
