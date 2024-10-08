internal class Solution {
  fun bestCoordinate(towers: Array<IntArray>, radius: Int): IntArray {
    var mx = 0
    var ans = intArrayOf(0, 0)
    for (i in 0..50) {
      for (j in 0..50) {
        var t = 0
        for (e in towers) {
          val d: Double = sqrt((i - e[0]) * (i - e[0]) + (j - e[1]) * (j - e[1]))
          if (d <= radius) {
            t += floor(e[2] / (1 + d))
          }
        }
        if (mx < t) {
          mx = t
          ans = intArrayOf(i, j)
        }
      }
    }
    return ans
  }
}
