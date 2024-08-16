internal class Solution {
  private var f: Array<Array<Int>>
  private var nums: IntArray
  private var s = 0
  private var n = 0

  fun maxOperations(nums: IntArray): Int {
    this.nums = nums
    n = nums.size
    val a = g(2, n - 1, nums[0] + nums[1])
    val b = g(0, n - 3, nums[n - 2] + nums[n - 1])
    val c = g(1, n - 2, nums[0] + nums[n - 1])
    return 1 + max(a, max(b, c))
  }

  private fun g(i: Int, j: Int, s: Int): Int {
    f = Array(n) { arrayOfNulls(n) }
    this.s = s
    return dfs(i, j)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (j - i < 1) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 0
    if (nums[i] + nums[i + 1] == s) {
      ans = max(ans, 1 + dfs(i + 2, j))
    }
    if (nums[i] + nums[j] == s) {
      ans = max(ans, 1 + dfs(i + 1, j - 1))
    }
    if (nums[j - 1] + nums[j] == s) {
      ans = max(ans, 1 + dfs(i, j - 2))
    }
    return ans.also { f[i][j] = it }
  }
}
