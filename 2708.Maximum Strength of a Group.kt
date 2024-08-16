internal class Solution {
  fun maxStrength(nums: IntArray): Long {
    var ans = -1e14.toLong()
    val n = nums.size
    for (i in 1 until (1 shl n)) {
      var t: Long = 1
      for (j in 0 until n) {
        if ((i shr j and 1) == 1) {
          t *= nums[j].toLong()
        }
      }
      ans = max(ans, t)
    }
    return ans
  }
}
