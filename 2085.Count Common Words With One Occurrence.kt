internal class Solution {
  fun countWords(words1: Array<String?>, words2: Array<String?>): Int {
    val cnt1: Map<String, Int> = HashMap()
    val cnt2: Map<String, Int> = HashMap()
    for (w in words1) {
      cnt1.merge(w, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    for (w in words2) {
      cnt2.merge(w, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    for (e in cnt1.entrySet()) {
      if (e.getValue() === 1 && cnt2.getOrDefault(e.getKey(), 0) === 1) {
        ++ans
      }
    }
    return ans
  }
}
