internal class Solution {
  fun returnToBoundaryCount(nums: IntArray): Int {
    var ans = 0
    var s = 0
    for (x in nums) {
      s += x
      if (s == 0) {
        ++ans
      }
    }
    return ans
  }
}
