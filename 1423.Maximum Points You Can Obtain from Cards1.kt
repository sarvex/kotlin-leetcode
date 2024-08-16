internal class Solution {
  fun maxScore(cardPoints: IntArray, k: Int): Int {
    var s = 0
    val n = cardPoints.size
    for (i in n - k until n) {
      s += cardPoints[i]
    }
    var ans = s
    for (i in 0 until k) {
      s += cardPoints[i] - cardPoints[n - k + i]
      ans = max(ans, s)
    }
    return ans
  }
}
