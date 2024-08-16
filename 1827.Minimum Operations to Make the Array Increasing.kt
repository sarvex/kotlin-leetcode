internal class Solution {
  fun minOperations(nums: IntArray): Int {
    var ans = 0
    var mx = 0
    for (v in nums) {
      ans += max(0, mx + 1 - v)
      mx = max(mx + 1, v)
    }
    return ans
  }
}
