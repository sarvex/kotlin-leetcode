internal class Solution {
  fun minimumDifference(nums: IntArray, k: Int): Int {
    var mx = 0
    for (x in nums) {
      mx = max(mx, x)
    }
    val m = 32 - Integer.numberOfLeadingZeros(mx)
    val cnt = IntArray(m)
    val n = nums.size
    var ans: Int = MAX_VALUE
    var i = 0
    var j = 0
    var s = 0
    while (j < n) {
      s = s or nums[j]
      ans = min(ans, abs(s - k))
      for (h in 0 until m) {
        if ((nums[j] shr h and 1) == 1) {
          ++cnt[h]
        }
      }
      while (i < j && s > k) {
        for (h in 0 until m) {
          if ((nums[i] shr h and 1) == 1 && --cnt[h] == 0) {
            s = s xor (1 shl h)
          }
        }
        ++i
        ans = min(ans, abs(s - k))
      }
      ++j
    }
    return ans
  }
}
