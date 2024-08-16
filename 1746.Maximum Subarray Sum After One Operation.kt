internal class Solution {
  fun maxSumAfterOperation(nums: IntArray): Int {
    var f = 0
    var g = 0
    var ans: Int = MIN_VALUE
    for (x in nums) {
      val ff: Int = max(f, 0) + x
      val gg: Int = max(max(f, 0) + x * x, g + x)
      f = ff
      g = gg
      ans = max(ans, max(f, g))
    }
    return ans
  }
}
