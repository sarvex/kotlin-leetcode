internal class Solution {
  fun findNumberOfLIS(nums: IntArray): Int {
    val n = nums.size
    val f = IntArray(n)
    val cnt = IntArray(n)
    var mx = 0
    var ans = 0
    for (i in 0 until n) {
      f[i] = 1
      cnt[i] = 1
      for (j in 0 until i) {
        if (nums[j] < nums[i]) {
          if (f[i] < f[j] + 1) {
            f[i] = f[j] + 1
            cnt[i] = cnt[j]
          } else if (f[i] == f[j] + 1) {
            cnt[i] += cnt[j]
          }
        }
      }
      if (mx < f[i]) {
        mx = f[i]
        ans = cnt[i]
      } else if (mx == f[i]) {
        ans += cnt[i]
      }
    }
    return ans
  }
}
