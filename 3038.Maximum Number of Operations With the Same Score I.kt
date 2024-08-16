internal class Solution {
  fun maxOperations(nums: IntArray): Int {
    val s = nums[0] + nums[1]
    var ans = 0
    val n = nums.size
    var i = 0
    while (i + 1 < n && nums[i] + nums[i + 1] == s) {
      ++ans
      i += 2
    }
    return ans
  }
}
