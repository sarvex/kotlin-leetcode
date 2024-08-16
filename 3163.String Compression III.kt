internal class Solution {
  fun compressedString(word: String): String {
    val ans = StringBuilder()
    val n = word.length
    var i = 0
    while (i < n) {
      var j = i + 1
      while (j < n && word[j] == word[i]) {
        ++j
      }
      var k = j - i
      while (k > 0) {
        val x: Int = min(9, k)
        ans.append(x).append(word[i])
        k -= x
      }
      i = j
    }
    return ans.toString()
  }
}
