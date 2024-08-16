internal class Solution {
  private var f: Array<Array<Int>>
  private var multipliers: IntArray
  private var nums: IntArray
  private var n = 0
  private var m = 0

  fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    n = nums.size
    m = multipliers.size
    f = Array(m) { arrayOfNulls(m) }
    this.nums = nums
    this.multipliers = multipliers
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= m || j >= m || (i + j) >= m) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    val k = i + j
    val a = dfs(i + 1, j) + nums[i] * multipliers[k]
    val b = dfs(i, j + 1) + nums[n - 1 - j] * multipliers[k]
    f[i][j] = max(a, b)
    return f[i][j]
  }
}
