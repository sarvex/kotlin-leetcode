internal class Solution {
  fun maxDistance(colors: IntArray): Int {
    var ans = 0
    val n = colors.size
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        if (colors[i] != colors[j]) {
          ans = max(ans, abs(i - j))
        }
      }
    }
    return ans
  }
}
