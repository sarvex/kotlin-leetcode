internal class Solution {
  fun minimumMoves(nums: IntArray, k: Int, maxChanges: Int): Long {
    val n = nums.size
    val cnt = IntArray(n + 1)
    val s = LongArray(n + 1)
    for (i in 1..n) {
      cnt[i] = cnt[i - 1] + nums[i - 1]
      s[i] = s[i - 1] + i * nums[i - 1]
    }
    var ans: Long = MAX_VALUE
    for (i in 1..n) {
      var t: Long = 0
      var need = k - nums[i - 1]
      var j = i - 1
      while (j <= i + 1) {
        if (need > 0 && 1 <= j && j <= n && nums[j - 1] == 1) {
          --need
          ++t
        }
        j += 2
      }
      val c: Int = min(need, maxChanges)
      need -= c
      t += (c * 2).toLong()
      if (need <= 0) {
        ans = min(ans, t)
        continue
      }
      var l = 2
      var r: Int = max(i - 1, n - i)
      while (l <= r) {
        val mid = (l + r) shr 1
        val l1: Int = max(1, i - mid)
        val r1: Int = max(0, i - 2)
        val l2: Int = min(n + 1, i + 2)
        val r2: Int = min(n, i + mid)
        val c1 = cnt[r1] - cnt[l1 - 1]
        val c2 = cnt[r2] - cnt[l2 - 1]
        if (c1 + c2 >= need) {
          val t1 = 1L * c1 * i - (s[r1] - s[l1 - 1])
          val t2 = s[r2] - s[l2 - 1] - 1L * c2 * i
          ans = min(ans, t + t1 + t2)
          r = mid - 1
        } else {
          l = mid + 1
        }
      }
    }
    return ans
  }
}
