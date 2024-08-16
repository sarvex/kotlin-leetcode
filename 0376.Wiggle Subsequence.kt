internal class Solution {
  fun wiggleMaxLength(nums: IntArray): Int {
    val n = nums.size
    var ans = 1
    val f = IntArray(n)
    val g = IntArray(n)
    f[0] = 1
    g[0] = 1
    for (i in 1 until n) {
      for (j in 0 until i) {
        if (nums[j] < nums[i]) {
          f[i] = max(f[i], g[j] + 1)
        } else if (nums[j] > nums[i]) {
          g[i] = max(g[i], f[j] + 1)
        }
      }
      ans = max(ans, max(f[i], g[i]))
    }
    return ans
  }
}
