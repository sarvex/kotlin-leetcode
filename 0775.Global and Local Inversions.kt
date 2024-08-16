internal class Solution {
  fun isIdealPermutation(nums: IntArray): Boolean {
    var mx = 0
    for (i in 2 until nums.size) {
      mx = max(mx, nums[i - 2])
      if (mx > nums[i]) {
        return false
      }
    }
    return true
  }
}
