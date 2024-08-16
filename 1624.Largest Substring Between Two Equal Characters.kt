internal class Solution {
  fun maxLengthBetweenEqualCharacters(s: String): Int {
    val d = IntArray(26)
    Arrays.fill(d, -1)
    var ans = -1
    for (i in 0 until s.length) {
      val j: Int = s[i].code - 'a'.code
      if (d[j] == -1) {
        d[j] = i
      } else {
        ans = max(ans, i - d[j] - 1)
      }
    }
    return ans
  }
}
