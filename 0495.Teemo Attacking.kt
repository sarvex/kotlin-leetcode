internal class Solution {
  fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    val n = timeSeries.size
    var ans = duration
    for (i in 1 until n) {
      ans += min(duration, timeSeries[i] - timeSeries[i - 1])
    }
    return ans
  }
}
