internal class Solution {
  fun removeAlmostEqualCharacters(word: String): Int {
    var ans = 0
    val n = word.length
    var i = 1
    while (i < n) {
      if (abs(word[i].code - word[i - 1].code) < 2) {
        ++ans
        ++i
      }
      ++i
    }
    return ans
  }
}
