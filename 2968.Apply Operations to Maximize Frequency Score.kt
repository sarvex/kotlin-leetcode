import java.util.*

internal class Solution {
  fun maxFrequencyScore(nums: IntArray, k: Long): Int {
    Arrays.sort(nums)
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + nums[i - 1]
    }
    var l = 0
    var r = n
    while (l < r) {
      val mid = (l + r + 1) shr 1
      var ok = false

      for (i in 0..(n - mid)) {
        val j = i + mid
        val x = nums[(i + j) / 2]
        val left = ((i + j) / 2 - i) * x.toLong() - (s[(i + j) / 2] - s[i])
        val right = (s[j] - s[(i + j) / 2]) - ((j - (i + j) / 2) * x.toLong())
        if (left + right <= k) {
          ok = true
          break
        }
      }

      if (ok) {
        l = mid
      } else {
        r = mid - 1
      }
    }

    return l
  }
}
