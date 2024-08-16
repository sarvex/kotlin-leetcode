internal class Solution {
  fun numberOfSpecialChars(word: String): Int {
    val first = IntArray('z'.code + 1)
    val last = IntArray('z'.code + 1)
    for (i in 1..word.length) {
      val j: Int = word[i - 1].code
      if (first[j] == 0) {
        first[j] = i
      }
      last[j] = i
    }
    var ans = 0
    for (i in 0..25) {
      if (last['a'.code + i] > 0 && first['A'.code + i] > 0 && last['a'.code + i] < first['A'.code + i]) {
        ++ans
      }
    }
    return ans
  }
}
