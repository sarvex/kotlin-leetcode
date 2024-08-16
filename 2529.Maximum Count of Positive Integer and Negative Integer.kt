internal class Solution {
  fun maximumCount(nums: IntArray): Int {
    var a = 0
    var b = 0
    for (x in nums) {
      if (x > 0) {
        ++a
      } else if (x < 0) {
        ++b
      }
    }
    return max(a, b)
  }
}
