internal class Solution {
  fun hIndex(citations: IntArray): Int {
    val n = citations.size
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) ushr 1
      if (citations[mid] >= n - mid) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return n - left
  }
}
