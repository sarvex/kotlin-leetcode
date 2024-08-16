internal class Solution {
  private var f: Array<Int>
  private var nums: IntArray

  fun rob(nums: IntArray): Int {
    this.nums = nums
    f = arrayOfNulls(nums.size)
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= nums.size) {
      return 0
    }
    if (f[i] == null) {
      f[i] = max(nums[i] + dfs(i + 2), dfs(i + 1))
    }
    return f[i]
  }
}
