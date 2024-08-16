internal class Solution {
  fun longestValidSubstring(word: String, forbidden: List<String?>?): Int {
    val s: HashSet = HashSet(forbidden)
    var ans = 0
    val n = word.length
    var i = 0
    var j = 0
    while (j < n) {
      var k = j
      while (k > max(j - 10, i - 1)) {
        if (s.contains(word.substring(k, j + 1))) {
          i = k + 1
          break
        }
        --k
      }
      ans = max(ans, j - i + 1)
      ++j
    }
    return ans
  }
}
