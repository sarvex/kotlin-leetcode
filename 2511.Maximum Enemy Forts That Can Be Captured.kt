internal class Solution {
  fun captureForts(forts: IntArray): Int {
    val n = forts.size
    var ans = 0
    var i = 0
    while (i < n) {
      var j = i + 1
      if (forts[i] != 0) {
        while (j < n && forts[j] == 0) {
          ++j
        }
        if (j < n && forts[i] + forts[j] == 0) {
          ans = max(ans, j - i - 1)
        }
      }
      i = j
    }
    return ans
  }
}
