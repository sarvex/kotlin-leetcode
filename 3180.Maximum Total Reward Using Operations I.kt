import java.util.*

internal class Solution {
  private var nums: IntArray
  private var f: Array<Int>

  fun maxTotalReward(rewardValues: IntArray): Int {
    nums = rewardValues
    Arrays.sort(nums)
    val n = nums.size
    f = arrayOfNulls(nums[n - 1] shl 1)
    return dfs(0)
  }

  private fun dfs(x: Int): Int {
    if (f[x] != null) {
      return f[x]
    }
    var i = Arrays.binarySearch(nums, x + 1)
    i = if (i < 0) -i - 1 else i
    var ans = 0
    while (i < nums.size) {
      ans = max(ans, nums[i] + dfs(x + nums[i]))
      ++i
    }
    return ans.also { f[x] = it }
  }
}
