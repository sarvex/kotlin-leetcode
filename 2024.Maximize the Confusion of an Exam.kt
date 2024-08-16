internal class Solution {
  private var s: CharArray
  private var k = 0

  fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
    s = answerKey.toCharArray()
    this.k = k
    return max(f('T'), f('F'))
  }

  private fun f(c: Char): Int {
    var l = 0
    var cnt = 0
    for (ch in s) {
      cnt += if (ch == c) 1 else 0
      if (cnt > k) {
        cnt -= if (s[l++] == c) 1 else 0
      }
    }
    return s.size - l
  }
}
