internal class Solution {
  fun findLonelyPixel(picture: Array<CharArray>): Int {
    val m = picture.size
    val n = picture[0].size
    val rows = IntArray(m)
    val cols = IntArray(n)
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (picture[i][j] == 'B') {
          ++rows[i]
          ++cols[j]
        }
      }
    }
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
          ++ans
        }
      }
    }
    return ans
  }
}
