internal class Solution {
  fun sortArrayByParityII(nums: IntArray): IntArray {
    var i = 0
    var j = 1
    while (i < nums.size) {
      if (nums[i] % 2 == 1) {
        while (nums[j] % 2 == 1) {
          j += 2
        }
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
      }
      i += 2
    }
    return nums
  }
}
