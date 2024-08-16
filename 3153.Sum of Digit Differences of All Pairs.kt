import java.util.*

internal class Solution {
  fun sumDigitDifferences(nums: IntArray): Long {
    val n = nums.size
    val m = floor(log10(nums[0])) as Int + 1
    val cnt = IntArray(10)
    var ans: Long = 0
    for (k in 0 until m) {
      Arrays.fill(cnt, 0)
      for (i in 0 until n) {
        ++cnt[nums[i] % 10]
        nums[i] /= 10
      }
      for (i in 0..9) {
        ans += 1L * cnt[i] * (n - cnt[i])
      }
    }
    return ans / 2
  }
}
