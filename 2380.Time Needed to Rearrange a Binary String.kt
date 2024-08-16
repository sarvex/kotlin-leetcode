internal class Solution {
  fun secondsToRemoveOccurrences(s: String): Int {
    val cs: CharArray = s.toCharArray()
    var find = true
    var ans = 0
    while (find) {
      find = false
      var i = 0
      while (i < cs.size - 1) {
        if (cs[i] == '0' && cs[i + 1] == '1') {
          val t = cs[i]
          cs[i] = cs[i + 1]
          cs[i + 1] = t
          ++i
          find = true
        }
        ++i
      }
      if (find) {
        ++ans
      }
    }
    return ans
  }
}
