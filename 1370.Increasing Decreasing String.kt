internal class Solution {
  fun sortString(s: String): String {
    val cnt = IntArray(26)
    val n = s.length
    for (i in 0 until n) {
      cnt[s[i].code - 'a'.code]++
    }
    val sb = StringBuilder()
    while (sb.length < n) {
      for (i in 0..25) {
        if (cnt[i] > 0) {
          sb.append(('a'.code + i).toChar())
          --cnt[i]
        }
      }
      for (i in 25 downTo 0) {
        if (cnt[i] > 0) {
          sb.append(('a'.code + i).toChar())
          --cnt[i]
        }
      }
    }
    return sb.toString()
  }
}
