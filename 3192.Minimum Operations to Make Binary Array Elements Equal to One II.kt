internal class Solution {
  fun minOperations(nums: IntArray): Int {
    var ans = 0
    var v = 0
    for (x in nums) {
      var x = x
      x = x xor v
      if (x == 0) {
        v = v xor 1
        ++ans
      }
    }
    return ans
  }
}
