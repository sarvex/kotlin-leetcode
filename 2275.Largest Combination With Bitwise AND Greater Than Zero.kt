internal class Solution {
  fun largestCombination(candidates: IntArray): Int {
    var ans = 0
    for (i in 0..31) {
      var t = 0
      for (x in candidates) {
        t += (x shr i) and 1
      }
      ans = max(ans, t)
    }
    return ans
  }
}
