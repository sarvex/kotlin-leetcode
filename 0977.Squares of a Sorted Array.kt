internal class Solution {
  fun sortedSquares(nums: IntArray): IntArray {
    val n = nums.size
    val ans = IntArray(n)
    var i = 0
    var j = n - 1
    var k = n - 1
    while (i <= j) {
      val a = nums[i] * nums[i]
      val b = nums[j] * nums[j]
      if (a > b) {
        ans[k] = a
        ++i
      } else {
        ans[k] = b
        --j
      }
      --k
    }
    return ans
  }
}
