internal class Solution {
  fun findContestMatch(n: Int): String {
    var n = n
    val s: Array<String> = arrayOfNulls(n)
    for (i in 0 until n) {
      s[i] = (i + 1).toString()
    }
    while (n > 1) {
      for (i in 0 until (n shr 1)) {
        s[i] = String.format("(%s,%s)", s[i], s[n - i - 1])
      }
      n = n shr 1
    }
    return s[0]
  }
}
