internal class Solution {
  private var nums: IntArray
  private var f: Array<IntArray>

  fun PredictTheWinner(nums: IntArray): Boolean {
    this.nums = nums
    val n = nums.size
    f = Array(n) { IntArray(n) }
    return dfs(0, n - 1) >= 0
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j) {
      return 0
    }
    if (f[i][j] != 0) {
      return f[i][j]
    }
    return max(nums[i] - dfs(i + 1, j), nums[j] - dfs(i, j - 1)).also { f[i][j] = it }
  }
}
