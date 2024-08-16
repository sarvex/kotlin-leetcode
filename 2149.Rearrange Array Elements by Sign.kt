internal class Solution {
  fun rearrangeArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var i = 0
    var j = 1
    for (x in nums) {
      if (x > 0) {
        ans[i] = x
        i += 2
      } else {
        ans[j] = x
        j += 2
      }
    }
    return ans
  }
}
