internal class Solution {
  fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
    val d = IntArray(26)
    for (i in d.indices) {
      d[i] = i + 1
    }
    val m = chars.length
    for (i in 0 until m) {
      d[chars[i].code - 'a'.code] = vals[i]
    }
    var ans = 0
    var tot = 0
    var mi = 0
    val n = s.length
    for (i in 0 until n) {
      val v = d[s[i].code - 'a'.code]
      tot += v
      ans = max(ans, tot - mi)
      mi = min(mi, tot)
    }
    return ans
  }
}
