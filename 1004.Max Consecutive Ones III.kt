internal class Solution {
  fun longestOnes(nums: IntArray, k: Int): Int {
    var l = 0
    var cnt = 0
    for (x in nums) {
      cnt += x xor 1
      if (cnt > k) {
        cnt -= nums[l++] xor 1
      }
    }
    return nums.size - l
  }
}
