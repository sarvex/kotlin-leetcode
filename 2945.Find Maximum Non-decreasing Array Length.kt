import java.util.*

internal class Solution {
  fun findMaximumLength(nums: IntArray): Int {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    val f = IntArray(n + 1)
    val pre = IntArray(n + 2)
    for (i in 1..n) {
      pre[i] = max(pre[i], pre[i - 1])
      f[i] = f[pre[i]] + 1
      val j = Arrays.binarySearch(s, s[i] * 2 - s[pre[i]])
      pre[if (j < 0) -j - 1 else j] = i
    }
    return f[n]
  }
}
