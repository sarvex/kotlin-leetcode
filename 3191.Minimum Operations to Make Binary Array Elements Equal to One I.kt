internal class Solution {
  fun minOperations(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    for (i in 0 until n) {
      if (nums[i] == 0) {
        if (i + 2 >= n) {
          return -1
        }
        nums[i + 1] = nums[i + 1] xor 1
        nums[i + 2] = nums[i + 2] xor 1
        ++ans
      }
    }
    return ans
  }
}
