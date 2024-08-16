internal class Solution {
  fun binarySearchableNumbers(nums: IntArray): Int {
    val n = nums.size
    val ok = IntArray(n)
    Arrays.fill(ok, 1)
    var mx = -1000000
    var mi = 1000000
    for (i in 0 until n) {
      if (nums[i] < mx) {
        ok[i] = 0
      }
      mx = max(mx, nums[i])
    }
    var ans = 0
    for (i in n - 1 downTo 0) {
      if (nums[i] > mi) {
        ok[i] = 0
      }
      mi = min(mi, nums[i])
      ans += ok[i]
    }
    return ans
  }
}
