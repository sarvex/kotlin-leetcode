internal class Solution {
  fun kthDistinct(arr: Array<String?>, k: Int): String? {
    var k = k
    val cnt: Map<String?, Int> = HashMap()
    for (s in arr) {
      cnt.merge(s, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    for (s in arr) {
      if (cnt[s] === 1 && --k == 0) {
        return s
      }
    }
    return ""
  }
}
