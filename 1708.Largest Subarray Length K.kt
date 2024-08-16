internal class Solution {
  fun largestSubarray(nums: IntArray, k: Int): IntArray {
    var j = 0
    for (i in 1 until nums.size - k + 1) {
      if (nums[j] < nums[i]) {
        j = i
      }
    }
    return Arrays.copyOfRange(nums, j, j + k)
  }
}
