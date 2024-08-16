internal class Solution {
  fun missingInteger(nums: IntArray): Int {
    var s = nums[0]
    var j = 1
    while (j < nums.size && nums[j] == nums[j - 1] + 1) {
      s += nums[j]
      ++j
    }
    val vis = BooleanArray(51)
    for (x in nums) {
      vis[x] = true
    }
    var x = s
    while (true) {
      if (x >= vis.size || !vis[x]) {
        return x
      }
      ++x
    }
  }
}
