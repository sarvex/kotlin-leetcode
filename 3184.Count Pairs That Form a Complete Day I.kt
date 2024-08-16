internal class Solution {
  fun countCompleteDayPairs(hours: IntArray): Int {
    val cnt = IntArray(24)
    var ans = 0
    for (x in hours) {
      ans += cnt[(24 - x % 24) % 24]
      ++cnt[x % 24]
    }
    return ans
  }
}
