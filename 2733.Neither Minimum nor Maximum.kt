internal class Solution {
  fun findNonMinOrMax(nums: IntArray): Int {
    var mi = 100
    var mx = 0
    for (x in nums) {
      mi = min(mi, x)
      mx = max(mx, x)
    }
    for (x in nums) {
      if (x != mi && x != mx) {
        return x
      }
    }
    return -1
  }
}
