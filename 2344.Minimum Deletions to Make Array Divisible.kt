import java.util.*

internal class Solution {
  fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
    var x = 0
    for (v in numsDivide) {
      x = gcd(x, v)
    }
    Arrays.sort(nums)
    for (i in nums.indices) {
      if (x % nums[i] == 0) {
        return i
      }
    }
    return -1
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
