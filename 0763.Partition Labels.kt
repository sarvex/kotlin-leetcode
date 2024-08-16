internal class Solution {
  fun partitionLabels(s: String): List<Int> {
    val last = IntArray(26)
    val n = s.length
    for (i in 0 until n) {
      last[s[i].code - 'a'.code] = i
    }
    val ans: List<Int> = ArrayList()
    var mx = 0
    var j = 0
    for (i in 0 until n) {
      mx = max(mx, last[s[i].code - 'a'.code])
      if (mx == i) {
        ans.add(i - j + 1)
        j = i + 1
      }
    }
    return ans
  }
}
