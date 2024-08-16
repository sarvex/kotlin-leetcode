internal class Solution {
  fun subStrHash(s: String, power: Int, modulo: Int, k: Int, hashValue: Int): String {
    var h: Long = 0
    var p: Long = 1
    val n = s.length
    for (i in n - 1 downTo n - k) {
      val `val`: Int = s[i].code - 'a'.code + 1
      h = ((h * power % modulo) + `val`) % modulo
      if (i != n - k) {
        p = p * power % modulo
      }
    }
    var j = n - k
    for (i in n - k - 1 downTo 0) {
      val pre: Int = s[i + k].code - 'a'.code + 1
      val cur: Int = s[i].code - 'a'.code + 1
      h = ((h - pre * p % modulo + modulo) * power % modulo + cur) % modulo
      if (h == hashValue.toLong()) {
        j = i
      }
    }
    return s.substring(j, j + k)
  }
}
