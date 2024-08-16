internal class Solution {
  fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var ans = 0
    var cnt = 0
    for (x in nums) {
      if (x == 1) {
        ans = max(ans, ++cnt)
      } else {
        cnt = 0
      }
    }
    return ans
  }
}
