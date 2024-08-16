internal class Solution {
  fun maxValueAfterReverse(nums: IntArray): Int {
    val n = nums.size
    var s = 0
    for (i in 0 until n - 1) {
      s += abs(nums[i] - nums[i + 1])
    }
    var ans = s
    for (i in 0 until n - 1) {
      ans = max(
        ans, s + abs(nums[0] - nums[i + 1]) - abs(nums[i] - nums[i + 1])
      )
      ans = max(
        ans, s + abs(nums[n - 1] - nums[i]) - abs(nums[i] - nums[i + 1])
      )
    }
    val dirs = intArrayOf(1, -1, -1, 1, 1)
    val inf = 1 shl 30
    for (k in 0..3) {
      val k1 = dirs[k]
      val k2 = dirs[k + 1]
      var mx = -inf
      var mi = inf
      for (i in 0 until n - 1) {
        val a = k1 * nums[i] + k2 * nums[i + 1]
        val b: Int = abs(nums[i] - nums[i + 1])
        mx = max(mx, a - b)
        mi = min(mi, a + b)
      }
      ans = max(ans, s + max(0, mx - mi))
    }
    return ans
  }
}
