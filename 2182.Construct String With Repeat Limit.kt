internal class Solution {
  fun repeatLimitedString(s: String, repeatLimit: Int): String {
    val cnt = IntArray(26)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - 'a'.code]
    }
    val ans = StringBuilder()
    var i = 25
    var j = 24
    while (i >= 0) {
      j = min(j, i - 1)
      while (true) {
        for (k in min(cnt[i], repeatLimit) downTo 1) {
          ans.append(('a'.code + i).toChar())
          --cnt[i]
        }
        if (cnt[i] == 0) {
          break
        }
        while (j >= 0 && cnt[j] == 0) {
          --j
        }
        if (j < 0) {
          break
        }
        ans.append(('a'.code + j).toChar())
        --cnt[j]
      }
      --i
    }
    return ans.toString()
  }
}
