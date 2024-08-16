import java.util.*

internal class Solution {
  fun countOfPairs(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val n = nums.size
    val m = Arrays.stream(nums).max().asInt
    val f = Array(n) { IntArray(m + 1) }
    for (j in 0..nums[0]) {
      f[0][j] = 1
    }
    val g = IntArray(m + 1)
    for (i in 1 until n) {
      g[0] = f[i - 1][0]
      for (j in 1..m) {
        g[j] = (g[j - 1] + f[i - 1][j]) % mod
      }
      for (j in 0..nums[i]) {
        val k: Int = min(j, j + nums[i - 1] - nums[i])
        if (k >= 0) {
          f[i][j] = g[k]
        }
      }
    }
    var ans = 0
    for (j in 0..nums[n - 1]) {
      ans = (ans + f[n - 1][j]) % mod
    }
    return ans
  }
}
