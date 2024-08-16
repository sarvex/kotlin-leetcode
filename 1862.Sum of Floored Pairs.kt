internal class Solution {
  fun sumOfFlooredPairs(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    var mx = 0
    for (x in nums) {
      mx = max(mx, x)
    }
    val cnt = IntArray(mx + 1)
    val s = IntArray(mx + 1)
    for (x in nums) {
      ++cnt[x]
    }
    for (i in 1..mx) {
      s[i] = s[i - 1] + cnt[i]
    }
    var ans: Long = 0
    for (y in 1..mx) {
      if (cnt[y] > 0) {
        var d = 1
        while (d * y <= mx) {
          ans += 1L * cnt[y] * d * (s[min(mx, d * y + y - 1)] - s[d * y - 1])
          ans %= mod.toLong()
          ++d
        }
      }
    }
    return ans.toInt()
  }
}
