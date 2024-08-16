internal class Solution {
  fun minOperations(nums: IntArray): Int {
    val n = nums.size
    var cnt = 0
    for (x in nums) {
      if (x == 1) {
        ++cnt
      }
    }
    if (cnt > 0) {
      return n - cnt
    }
    var mi = n + 1
    for (i in 0 until n) {
      var g = 0
      for (j in i until n) {
        g = gcd(g, nums[j])
        if (g == 1) {
          mi = min(mi, j - i + 1)
        }
      }
    }
    return if (mi > n) -1 else n - 1 + mi - 1
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
