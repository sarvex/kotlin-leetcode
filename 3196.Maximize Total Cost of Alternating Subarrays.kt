internal class Solution {
  private var f: Array<Array<Long>>
  private var nums: IntArray
  private var n = 0

  fun maximumTotalCost(nums: IntArray): Long {
    n = nums.size
    this.nums = nums
    f = Array(n) { arrayOfNulls(2) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Long {
    if (i >= n) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    f[i][j] = nums[i] + dfs(i + 1, 1)
    if (j == 1) {
      f[i][j] = max(f[i][j], -nums[i] + dfs(i + 1, 0))
    }
    return f[i][j]
  }
}
