internal class Solution {
  fun isConsecutive(nums: IntArray): Boolean {
    var mi = nums[0]
    var mx = nums[0]
    val s: Set<Int> = HashSet()
    for (v in nums) {
      mi = min(mi, v)
      mx = max(mx, v)
      s.add(v)
    }
    val n = nums.size
    return s.size() === n && mx == mi + n - 1
  }
}
