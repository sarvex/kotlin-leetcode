internal class Solution {
  private var nums: IntArray
  private var s: LongArray
  private var k = 0

  fun maxFrequency(nums: IntArray, k: Int): Int {
    this.k = k
    this.nums = nums
    Arrays.sort(nums)
    val n = nums.size
    s = LongArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + nums[i - 1]
    }
    var l = 1
    var r = n
    while (l < r) {
      val mid = (l + r + 1) shr 1
      if (check(mid)) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return l
  }

  private fun check(m: Int): Boolean {
    for (i in m..nums.size) {
      if (1L * nums[i - 1] * m - (s[i] - s[i - m]) <= k) {
        return true
      }
    }
    return false
  }
}
