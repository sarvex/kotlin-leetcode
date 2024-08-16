internal class Solution {
  fun maximumStrongPairXor(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      for (y in nums) {
        if (abs(x - y) <= min(x, y)) {
          ans = max(ans, x xor y)
        }
      }
    }
    return ans
  }
}
