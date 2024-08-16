internal class Solution {
  private val ans: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var nums: IntArray

  fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    Arrays.sort(nums)
    this.nums = nums
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    var i = i
    if (i >= nums.size) {
      ans.add(ArrayList(t))
      return
    }
    t.add(nums[i])
    dfs(i + 1)
    val x: Int = t.remove(t.size() - 1)
    while (i + 1 < nums.size && nums[i + 1] == x) {
      ++i
    }
    dfs(i + 1)
  }
}
