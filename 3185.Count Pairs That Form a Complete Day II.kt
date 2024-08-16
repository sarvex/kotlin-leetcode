internal class Solution {
  fun countCompleteDayPairs(hours: IntArray): Long {
    val cnt = IntArray(24)
    var ans: Long = 0
    for (x in hours) {
      ans += cnt[(24 - x % 24) % 24].toLong()
      ++cnt[x % 24]
    }
    return ans
  }
}
