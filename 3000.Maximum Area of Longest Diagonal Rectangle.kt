internal class Solution {
  fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var ans = 0
    var mx = 0
    for (d in dimensions) {
      val l = d[0]
      val w = d[1]
      val t = l * l + w * w
      if (mx < t) {
        mx = t
        ans = l * w
      } else if (mx == t) {
        ans = max(ans, l * w)
      }
    }
    return ans
  }
}
