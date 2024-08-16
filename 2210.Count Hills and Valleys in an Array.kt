internal class Solution {
  fun countHillValley(nums: IntArray): Int {
    var ans = 0
    var j = 0
    for (i in 1 until nums.size - 1) {
      if (nums[i] == nums[i + 1]) {
        continue
      }
      if (nums[i] > nums[j] && nums[i] > nums[i + 1]) {
        ++ans
      }
      if (nums[i] < nums[j] && nums[i] < nums[i + 1]) {
        ++ans
      }
      j = i
    }
    return ans
  }
}
