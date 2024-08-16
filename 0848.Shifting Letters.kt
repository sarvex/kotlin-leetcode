internal class Solution {
  fun shiftingLetters(s: String, shifts: IntArray): String {
    val cs: CharArray = s.toCharArray()
    val n = cs.size
    var t: Long = 0
    for (i in n - 1 downTo 0) {
      t += shifts[i].toLong()
      val j: Int = ((cs[i].code - 'a'.code + t) % 26).toInt()
      cs[i] = ('a'.code + j).toChar()
    }
    return String(cs)
  }
}
