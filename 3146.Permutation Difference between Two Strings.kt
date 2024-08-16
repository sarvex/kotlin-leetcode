internal class Solution {
  fun findPermutationDifference(s: String, t: String): Int {
    val d = IntArray(26)
    val n = s.length
    for (i in 0 until n) {
      d[s[i].code - 'a'.code] = i
    }
    var ans = 0
    for (i in 0 until n) {
      ans += abs(d[t[i].code - 'a'.code] - i)
    }
    return ans
  }
}
