internal class Solution {
  fun getHint(secret: String, guess: String): String {
    var x = 0
    var y = 0
    val cnt1 = IntArray(10)
    val cnt2 = IntArray(10)
    for (i in 0 until secret.length) {
      val a: Int = secret[i].code - '0'.code
      val b: Int = guess[i].code - '0'.code
      if (a == b) {
        ++x
      } else {
        ++cnt1[a]
        ++cnt2[b]
      }
    }
    for (i in 0..9) {
      y += min(cnt1[i], cnt2[i])
    }
    return String.format("%dA%dB", x, y)
  }
}
