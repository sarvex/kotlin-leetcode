internal class Solution {
  fun maxScoreSightseeingPair(values: IntArray): Int {
    var ans = 0
    var mx = values[0]
    for (j in 1 until values.size) {
      ans = max(ans, values[j] - j + mx)
      mx = max(mx, values[j] + j)
    }
    return ans
  }
}
