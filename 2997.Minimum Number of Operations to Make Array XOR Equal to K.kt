internal class Solution {
  fun minOperations(nums: IntArray, k: Int): Int {
    var k = k
    for (x in nums) {
      k = k xor x
    }
    return Integer.bitCount(k)
  }
}
