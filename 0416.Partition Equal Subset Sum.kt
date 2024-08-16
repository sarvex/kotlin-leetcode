internal class Solution {
  fun canPartition(nums: IntArray): Boolean {
    // int s = Arrays.stream(nums).sum();
    var s = 0
    for (x in nums) {
      s += x
    }
    if (s % 2 == 1) {
      return false
    }
    val n = nums.size
    val m = s shr 1
    val f = Array(n + 1) { BooleanArray(m + 1) }
    f[0][0] = true
    for (i in 1..n) {
      val x = nums[i - 1]
      for (j in 0..m) {
        f[i][j] = f[i - 1][j] || (j >= x && f[i - 1][j - x])
      }
    }
    return f[n][m]
  }
}
