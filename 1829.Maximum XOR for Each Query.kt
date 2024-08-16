internal class Solution {
  fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
    val n = nums.size
    var xs = 0
    for (x in nums) {
      xs = xs xor x
    }
    val ans = IntArray(n)
    for (i in 0 until n) {
      val x = nums[n - i - 1]
      var k = 0
      for (j in maximumBit - 1 downTo 0) {
        if (((xs shr j) and 1) == 0) {
          k = k or (1 shl j)
        }
      }
      ans[i] = k
      xs = xs xor x
    }
    return ans
  }
}
