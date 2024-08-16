import java.util.*

internal class Solution {
  fun maximumStrength(nums: IntArray, k: Int): Long {
    val n = nums.size
    val f = Array(n + 1) { Array(k + 1) { LongArray(2) } }
    for (i in 0..n) {
      for (j in 0..k) {
        Arrays.fill(f[i][j], MIN_VALUE / 2)
      }
    }
    f[0][0][0] = 0
    for (i in 1..n) {
      val x = nums[i - 1]
      for (j in 0..k) {
        val sign = (if ((j and 1) == 1) 1 else -1).toLong()
        val `val` = sign * x * (k - j + 1)
        f[i][j][0] = max(f[i - 1][j][0], f[i - 1][j][1])
        f[i][j][1] = max(f[i][j][1], f[i - 1][j][1] + `val`)
        if (j > 0) {
          val t: Long = max(f[i - 1][j - 1][0], f[i - 1][j - 1][1]) + `val`
          f[i][j][1] = max(f[i][j][1], t)
        }
      }
    }
    return max(f[n][k][0], f[n][k][1])
  }
}
