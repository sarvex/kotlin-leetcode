internal class Solution {
  private var f: Array<Int>
  private var nums: IntArray
  private var n = 0

  fun maxScore(nums: IntArray): Int {
    n = nums.size
    f = arrayOfNulls(n)
    this.nums = nums
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (f[i] != null) {
      return f[i]
    }
    f[i] = 0
    for (j in i + 1 until n) {
      f[i] = max(f[i], (j - i) * nums[j] + dfs(j))
    }
    return f[i]
  }
}
