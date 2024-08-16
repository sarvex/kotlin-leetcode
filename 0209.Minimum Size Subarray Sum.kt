internal class Solution {
  fun minSubArrayLen(target: Int, nums: IntArray): Int {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans = n + 1
    for (i in 0..n) {
      val j = search(s, s[i] + target)
      if (j <= n) {
        ans = min(ans, j - i)
      }
    }
    return if (ans <= n) ans else 0
  }

  private fun search(nums: LongArray, x: Long): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = (l + r) shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
