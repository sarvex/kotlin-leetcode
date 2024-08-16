internal class Solution {
  fun countSubarrays(nums: IntArray, k: Long): Long {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans: Long = 0
    for (i in 1..n) {
      var left = 0
      var right = i
      while (left < right) {
        val mid = (left + right + 1) shr 1
        if ((s[i] - s[i - mid]) * mid < k) {
          left = mid
        } else {
          right = mid - 1
        }
      }
      ans += left.toLong()
    }
    return ans
  }
}
