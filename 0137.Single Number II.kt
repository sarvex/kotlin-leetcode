internal class Solution {
  fun singleNumber(nums: IntArray): Int {
    var ans = 0
    for (i in 0..31) {
      var cnt = 0
      for (num in nums) {
        cnt += num shr i and 1
      }
      cnt %= 3
      ans = ans or (cnt shl i)
    }
    return ans
  }
}
