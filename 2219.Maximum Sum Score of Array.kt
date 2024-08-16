internal class Solution {
  fun maximumSumScore(nums: IntArray): Long {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans: Long = MIN_VALUE
    for (i in 0 until n) {
      ans = max(ans, max(s[i + 1], s[n] - s[i]))
    }
    return ans
  }
}
