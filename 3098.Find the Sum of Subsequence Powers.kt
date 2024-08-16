import java.util.*

internal class Solution {
  private val f: Map<Long, Int> = HashMap()
  private val mod = 1e9.toInt() + 7
  private var nums: IntArray

  fun sumOfPowers(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    this.nums = nums
    return dfs(0, nums.size, k, MAX_VALUE)
  }

  private fun dfs(i: Int, j: Int, k: Int, mi: Int): Int {
    if (i >= nums.size) {
      return if (k == 0) mi else 0
    }
    if (nums.size - i < k) {
      return 0
    }
    val key = (1L * mi) shl 18 or (i shl 12).toLong() or (j shl 6).toLong() or k.toLong()
    if (f.containsKey(key)) {
      return f[key]!!
    }
    var ans = dfs(i + 1, j, k, mi)
    ans += if (j == nums.size) {
      dfs(i + 1, i, k - 1, mi)
    } else {
      dfs(i + 1, i, k - 1, min(mi, nums[i] - nums[j]))
    }
    ans %= mod
    f.put(key, ans)
    return ans
  }
}
