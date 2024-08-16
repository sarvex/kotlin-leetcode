internal class Solution {
  fun countLatticePoints(circles: Array<IntArray>): Int {
    var mx = 0
    var my = 0
    for (c in circles) {
      mx = max(mx, c[0] + c[2])
      my = max(my, c[1] + c[2])
    }
    var ans = 0
    for (i in 0..mx) {
      for (j in 0..my) {
        for (c in circles) {
          val dx = i - c[0]
          val dy = j - c[1]
          if (dx * dx + dy * dy <= c[2] * c[2]) {
            ++ans
            break
          }
        }
      }
    }
    return ans
  }
}
