internal class Solution {
  fun minCost(nums: IntArray, x: Int): Long {
    val n = nums.size
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][0] = nums[i]
      for (j in 1 until n) {
        f[i][j] = min(f[i][j - 1], nums[(i - j + n) % n])
      }
    }
    var ans = 1L shl 60
    for (j in 0 until n) {
      var cost: Long = 1L * x * j
      for (i in 0 until n) {
        cost += f[i][j].toLong()
      }
      ans = min(ans, cost)
    }
    return ans
  }
}
