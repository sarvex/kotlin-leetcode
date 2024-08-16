import java.util.*

internal class Solution {
  fun lengthOfLongestSubsequence(nums: List<Int>, target: Int): Int {
    val n: Int = nums.size()
    val f = Array(n + 1) { IntArray(target + 1) }
    val inf = 1 shl 30
    for (g in f) {
      Arrays.fill(g, -inf)
    }
    f[0][0] = 0
    for (i in 1..n) {
      val x = nums[i - 1]
      for (j in 0..target) {
        f[i][j] = f[i - 1][j]
        if (j >= x) {
          f[i][j] = max(f[i][j], f[i - 1][j - x] + 1)
        }
      }
    }
    return if (f[n][target] <= 0) -1 else f[n][target]
  }
}
