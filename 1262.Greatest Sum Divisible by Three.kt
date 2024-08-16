internal class Solution {
  fun maxSumDivThree(nums: IntArray): Int {
    val n = nums.size
    val inf = 1 shl 30
    val f = Array(n + 1) { IntArray(3) }
    f[0][2] = -inf
    f[0][1] = f[0][2]
    for (i in 1..n) {
      val x = nums[i - 1]
      for (j in 0..2) {
        f[i][j] = max(f[i - 1][j], f[i - 1][(j - x % 3 + 3) % 3] + x)
      }
    }
    return f[n][0]
  }
}
