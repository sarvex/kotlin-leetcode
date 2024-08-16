internal class Solution {
  fun findBlackPixel(picture: Array<CharArray>, target: Int): Int {
    val m = picture.size
    val n = picture[0].size
    val g: Array<List<Int>> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val rows = IntArray(m)
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (picture[i][j] == 'B') {
          ++rows[i]
          g[j].add(i)
        }
      }
    }
    var ans = 0
    for (j in 0 until n) {
      if (g[j].isEmpty() || (rows[g[j][0]] != target)) {
        continue
      }
      val i1 = g[j][0]
      var ok = 0
      if (g[j].size() === rows[i1]) {
        ok = target
        for (i2 in g[j]) {
          if (!Arrays.equals(picture[i1], picture[i2])) {
            ok = 0
            break
          }
        }
      }
      ans += ok
    }
    return ans
  }
}
