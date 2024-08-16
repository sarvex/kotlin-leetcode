internal class Solution {
  fun minIncrementForUnique(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 0
    var y = -1
    for (x in nums) {
      y = max(y + 1, x)
      ans += y - x
    }
    return ans
  }
}
