internal class Solution {
  fun minimumOperations(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      val mod = x % 3
      if (mod != 0) {
        ans += min(mod, 3 - mod)
      }
    }
    return ans
  }
}
