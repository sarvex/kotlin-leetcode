internal class Solution {
  fun hIndex(citations: IntArray): Int {
    Arrays.sort(citations)
    val n = citations.size
    for (h in n downTo 1) {
      if (citations[n - h] >= h) {
        return h
      }
    }
    return 0
  }
}
