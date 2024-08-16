internal class Solution {
  fun countSpecialSubsequences(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val n = nums.size
    val f = Array(n) { IntArray(3) }
    f[0][0] = if (nums[0] == 0) 1 else 0
    for (i in 1 until n) {
      if (nums[i] == 0) {
        f[i][0] = (2 * f[i - 1][0] % mod + 1) % mod
        f[i][1] = f[i - 1][1]
        f[i][2] = f[i - 1][2]
      } else if (nums[i] == 1) {
        f[i][0] = f[i - 1][0]
        f[i][1] = (f[i - 1][0] + 2 * f[i - 1][1] % mod) % mod
        f[i][2] = f[i - 1][2]
      } else {
        f[i][0] = f[i - 1][0]
        f[i][1] = f[i - 1][1]
        f[i][2] = (f[i - 1][1] + 2 * f[i - 1][2] % mod) % mod
      }
    }
    return f[n - 1][2]
  }
}
