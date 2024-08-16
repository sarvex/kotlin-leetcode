internal class Solution {
  fun shortestWordDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    var ans = wordsDict.size
    if (word1 == word2) {
      var i = 0
      var j = -1
      while (i < wordsDict.size) {
        if (wordsDict[i] == word1) {
          if (j != -1) {
            ans = min(ans, i - j)
          }
          j = i
        }
        ++i
      }
    } else {
      var k = 0
      var i = -1
      var j = -1
      while (k < wordsDict.size) {
        if (wordsDict[k] == word1) {
          i = k
        }
        if (wordsDict[k] == word2) {
          j = k
        }
        if (i != -1 && j != -1) {
          ans = min(ans, abs(i - j))
        }
        ++k
      }
    }
    return ans
  }
}
