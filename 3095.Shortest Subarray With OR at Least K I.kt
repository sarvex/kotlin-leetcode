internal class Solution {
  fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
    val n = nums.size
    val cnt = IntArray(32)
    var ans = n + 1
    var i = 0
    var j = 0
    var s = 0
    while (j < n) {
      s = s or nums[j]
      for (h in 0..31) {
        if ((nums[j] shr h and 1) == 1) {
          ++cnt[h]
        }
      }
      while (s >= k && i <= j) {
        ans = min(ans, j - i + 1)
        for (h in 0..31) {
          if ((nums[i] shr h and 1) == 1) {
            if (--cnt[h] == 0) {
              s = s xor (1 shl h)
            }
          }
        }
        ++i
      }
      ++j
    }
    return if (ans > n) -1 else ans
  }
}
