internal class Solution {
  fun hasTrailingZeros(nums: IntArray): Boolean {
    var cnt = 0
    for (x in nums) {
      cnt += (x and 1 xor 1)
    }
    return cnt >= 2
  }
}
