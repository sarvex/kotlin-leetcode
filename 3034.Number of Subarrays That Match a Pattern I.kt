internal class Solution {
  fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int {
    val n = nums.size
    val m = pattern.size
    var ans = 0
    for (i in 0 until n - m) {
      var ok = 1
      var k = 0
      while (k < m && ok == 1) {
        if (f(nums[i + k], nums[i + k + 1]) != pattern[k]) {
          ok = 0
        }
        ++k
      }
      ans += ok
    }
    return ans
  }

  private fun f(a: Int, b: Int): Int {
    return if (a == b) 0 else (if (a < b) 1 else -1)
  }
}
