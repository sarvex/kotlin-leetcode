internal class Solution {
  private var n = 0
  private var s: CharArray
  private val cnt = IntArray(26)

  fun minAnagramLength(s: String): Int {
    n = s.length
    this.s = s.toCharArray()
    for (i in 0 until n) {
      ++cnt[this.s[i].code - 'a'.code]
    }
    var i = 1
    while (true) {
      if (n % i == 0 && check(i)) {
        return i
      }
      ++i
    }
  }

  private fun check(k: Int): Boolean {
    var i = 0
    while (i < n) {
      val cnt1 = IntArray(26)
      for (j in i until i + k) {
        ++cnt1[s[j].code - 'a'.code]
      }
      for (j in 0..25) {
        if (cnt1[j] * (n / k) != cnt[j]) {
          return false
        }
      }
      i += k
    }
    return true
  }
}
