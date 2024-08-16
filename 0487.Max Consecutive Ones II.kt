internal class Solution {
  fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var l = 0
    var cnt = 0
    for (x in nums) {
      cnt += x xor 1
      if (cnt > 1) {
        cnt -= nums[l++] xor 1
      }
    }
    return nums.size - l
  }
}
