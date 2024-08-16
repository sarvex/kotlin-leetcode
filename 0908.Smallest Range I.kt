internal class Solution {
  fun smallestRangeI(nums: IntArray, k: Int): Int {
    var mx = 0
    var mi = 10000
    for (v in nums) {
      mx = max(mx, v)
      mi = min(mi, v)
    }
    return max(0, mx - mi - k * 2)
  }
}
