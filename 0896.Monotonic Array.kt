internal class Solution {
  fun isMonotonic(nums: IntArray): Boolean {
    var asc = false
    var desc = false
    for (i in 1 until nums.size) {
      if (nums[i - 1] < nums[i]) {
        asc = true
      } else if (nums[i - 1] > nums[i]) {
        desc = true
      }
      if (asc && desc) {
        return false
      }
    }
    return true
  }
}
