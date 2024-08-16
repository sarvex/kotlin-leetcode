internal class Solution {
  fun minimumLevels(possible: IntArray): Int {
    var s = 0
    for (x in possible) {
      s += if (x == 0) -1 else 1
    }
    var t = 0
    for (i in 1 until possible.size) {
      t += if (possible[i - 1] == 0) -1 else 1
      if (t > s - t) {
        return i
      }
    }
    return -1
  }
}
