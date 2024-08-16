internal class Solution {
  fun sumOfEncryptedInt(nums: IntArray): Int {
    var ans = 0
    for (x in nums) {
      ans += encrypt(x)
    }
    return ans
  }

  private fun encrypt(x: Int): Int {
    var x = x
    var mx = 0
    var p = 0
    while (x > 0) {
      mx = max(mx, x % 10)
      p = p * 10 + 1
      x /= 10
    }
    return mx * p
  }
}
