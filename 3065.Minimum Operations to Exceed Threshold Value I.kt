internal class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
    var ans = 0
    for (x in nums) {
      if (x < k) {
        ++ans
      }
    }
    return ans
  }
}
