internal class Solution {
  fun minimumTimeToInitialState(word: String, k: Int): Int {
    val n = word.length
    var i = k
    while (i < n) {
      if (word.substring(i) == word.substring(0, n - i)) {
        return i / k
      }
      i += k
    }
    return (n + k - 1) / k
  }
}
