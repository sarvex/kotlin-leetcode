internal class Solution {
  fun specialArray(nums: IntArray): Int {
    for (x in 1..nums.size) {
      var cnt = 0
      for (v in nums) {
        if (v >= x) {
          ++cnt
        }
      }
      if (cnt == x) {
        return x
      }
    }
    return -1
  }
}
