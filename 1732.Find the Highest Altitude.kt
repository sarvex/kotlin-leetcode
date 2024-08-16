internal class Solution {
  fun largestAltitude(gain: IntArray): Int {
    var ans = 0
    var h = 0
    for (v in gain) {
      h += v
      ans = max(ans, h)
    }
    return ans
  }
}
