internal class Solution {
  fun mostWordsFound(sentences: Array<String>): Int {
    var ans = 0
    for (s in sentences) {
      var cnt = 1
      for (i in 0 until s.length) {
        if (s[i] == ' ') {
          ++cnt
        }
      }
      ans = max(ans, cnt)
    }
    return ans
  }
}
