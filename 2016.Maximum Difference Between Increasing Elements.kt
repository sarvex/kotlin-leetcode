internal class Solution {
  fun maximumDifference(nums: IntArray): Int {
    var mi = 1 shl 30
    var ans = -1
    for (x in nums) {
      if (x > mi) {
        ans = max(ans, x - mi)
      } else {
        mi = x
      }
    }
    return ans
  }
}
