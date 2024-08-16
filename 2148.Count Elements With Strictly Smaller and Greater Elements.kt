internal class Solution {
  fun countElements(nums: IntArray): Int {
    var mi = 1000000
    var mx = -1000000
    for (num in nums) {
      mi = min(mi, num)
      mx = max(mx, num)
    }
    var ans = 0
    for (num in nums) {
      if (mi < num && num < mx) {
        ++ans
      }
    }
    return ans
  }
}
