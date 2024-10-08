internal class Solution {
  fun minimumDistance(word: String): Int {
    val n = word.length
    val inf = 1 shl 30
    val f = Array(n) { Array(26) { IntArray(26) } }
    for (g in f) {
      for (h in g) {
        Arrays.fill(h, inf)
      }
    }
    for (j in 0..25) {
      f[0][word[0].code - 'A'.code][j] = 0
      f[0][j][word[0].code - 'A'.code] = 0
    }
    for (i in 1 until n) {
      val a: Int = word[i - 1].code - 'A'.code
      val b: Int = word[i].code - 'A'.code
      val d = dist(a, b)
      for (j in 0..25) {
        f[i][b][j] = min(f[i][b][j], f[i - 1][a][j] + d)
        f[i][j][b] = min(f[i][j][b], f[i - 1][j][a] + d)
        if (j == a) {
          for (k in 0..25) {
            val t = dist(k, b)
            f[i][b][j] = min(f[i][b][j], f[i - 1][k][a] + t)
            f[i][j][b] = min(f[i][j][b], f[i - 1][a][k] + t)
          }
        }
      }
    }
    var ans = inf
    for (j in 0..25) {
      ans = min(ans, f[n - 1][j][word[n - 1].code - 'A'.code])
      ans = min(ans, f[n - 1][word[n - 1].code - 'A'.code][j])
    }
    return ans
  }

  private fun dist(a: Int, b: Int): Int {
    val x1 = a / 6
    val y1 = a % 6
    val x2 = b / 6
    val y2 = b % 6
    return abs(x1 - x2) + abs(y1 - y2)
  }
}
