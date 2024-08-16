internal class Solution {
  fun subsetXORSum(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until (1 shl n)) {
      var s = 0
      for (j in 0 until n) {
        if ((i shr j and 1) == 1) {
          s = s xor nums[j]
        }
      }
      ans += s
    }
    return ans
  }
}
