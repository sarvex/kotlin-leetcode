internal class Solution {
  fun sortArrayByParity(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size - 1
    while (i < j) {
      if (nums[i] % 2 == 0) {
        ++i
      } else if (nums[j] % 2 == 1) {
        --j
      } else {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
        ++i
        --j
      }
    }
    return nums
  }
}
