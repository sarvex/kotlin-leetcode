internal class Solution {
  fun maximumAlternatingSubarraySum(nums: IntArray): Long {
    val inf = 1L shl 60
    var ans = -inf
    var f = -inf
    var g = -inf
    for (x in nums) {
      val ff: Long = max(g, 0) + x
      g = f - x
      f = ff
      ans = max(ans, max(f, g))
    }
    return ans
  }
}
