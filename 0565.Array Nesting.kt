internal class Solution {
  fun arrayNesting(nums: IntArray): Int {
    val n = nums.size
    val vis = BooleanArray(n)
    var res = 0
    for (i in 0 until n) {
      if (vis[i]) {
        continue
      }
      var cur = nums[i]
      var m = 1
      vis[cur] = true
      while (nums[cur] != nums[i]) {
        cur = nums[cur]
        m++
        vis[cur] = true
      }
      res = max(res, m)
    }
    return res
  }
}
