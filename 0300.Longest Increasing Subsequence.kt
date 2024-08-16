internal class Solution {
  fun lengthOfLIS(nums: IntArray): Int {
    val n = nums.size
    val f = IntArray(n)
    Arrays.fill(f, 1)
    var ans = 1
    for (i in 1 until n) {
      for (j in 0 until i) {
        if (nums[j] < nums[i]) {
          f[i] = max(f[i], f[j] + 1)
        }
      }
      ans = max(ans, f[i])
    }
    return ans
  }
}
