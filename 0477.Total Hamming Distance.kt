internal class Solution {
  fun totalHammingDistance(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    for (i in 0..31) {
      var a = 0
      for (x in nums) {
        a += (x shr i and 1)
      }
      val b = n - a
      ans += a * b
    }
    return ans
  }
}
