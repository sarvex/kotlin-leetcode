internal class Solution {
  fun numTimesAllBlue(flips: IntArray): Int {
    var ans = 0
    var mx = 0
    for (i in 1..flips.size) {
      mx = max(mx, flips[i - 1])
      if (mx == i) {
        ++ans
      }
    }
    return ans
  }
}
