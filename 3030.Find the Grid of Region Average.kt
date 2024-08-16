internal class Solution {
  fun resultGrid(image: Array<IntArray>, threshold: Int): Array<IntArray> {
    val n = image.size
    val m = image[0].size
    val ans = Array(n) { IntArray(m) }
    val ct = Array(n) { IntArray(m) }
    run {
      var i = 0
      while (i + 2 < n) {
        var j = 0
        while (j + 2 < m) {
          val region = true
          for (k in 0..2) {
            for (l in 0..1) {
              region
              = region
              and(abs(image[i + k][j + l] - image[i + k][j + l + 1]) <= threshold)
            }
          }
          for (k in 0..1) {
            for (l in 0..2) {
              region
              = region
              and(abs(image[i + k][j + l] - image[i + k + 1][j + l]) <= threshold)
            }
          }
          if (region) {
            var tot = 0
            for (k in 0..2) {
              for (l in 0..2) {
                tot += image[i + k][j + l]
              }
            }
            for (k in 0..2) {
              for (l in 0..2) {
                ct[i + k][j + l]++
                ans[i + k][j + l] += tot / 9
              }
            }
          }
          ++j
        }
        ++i
      }
    }
    for (i in 0 until n) {
      for (j in 0 until m) {
        if (ct[i][j] == 0) {
          ans[i][j] = image[i][j]
        } else {
          ans[i][j] /= ct[i][j]
        }
      }
    }
    return ans
  }
}
