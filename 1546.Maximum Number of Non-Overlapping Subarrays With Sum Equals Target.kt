internal class Solution {
  fun maxNonOverlapping(nums: IntArray, target: Int): Int {
    var ans = 0
    val n = nums.size
    var i = 0
    while (i < n) {
      val vis: Set<Int> = HashSet()
      var s = 0
      vis.add(0)
      while (i < n) {
        s += nums[i]
        if (vis.contains(s - target)) {
          ++ans
          break
        }
        ++i
        vis.add(s)
      }
      ++i
    }
    return ans
  }
}
