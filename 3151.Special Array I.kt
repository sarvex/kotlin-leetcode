internal class Solution {
  fun isArraySpecial(nums: IntArray): Boolean {
    for (i in 1 until nums.size) {
      if (nums[i] % 2 == nums[i - 1] % 2) {
        return false
      }
    }
    return true
  }
}
