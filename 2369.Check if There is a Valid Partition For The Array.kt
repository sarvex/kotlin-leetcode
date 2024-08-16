internal class Solution {
  private var n = 0
  private var nums: IntArray
  private var f: Array<Boolean>

  fun validPartition(nums: IntArray): Boolean {
    n = nums.size
    this.nums = nums
    f = arrayOfNulls(n)
    return dfs(0)
  }

  private fun dfs(i: Int): Boolean {
    if (i >= n) {
      return true
    }
    if (f[i] != null) {
      return f[i]
    }
    val a = i + 1 < n && nums[i] == nums[i + 1]
    val b = i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]
    val c = i + 2 < n && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1
    return ((a && dfs(i + 2)) || ((b || c) && dfs(i + 3))).also { f[i] = it }
  }
}
