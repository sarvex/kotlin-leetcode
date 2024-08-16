internal class Solution {
  fun maximumTripletValue(nums: IntArray): Long {
    var max: Long
    var maxDiff: Long
    var ans: Long
    max = 0
    maxDiff = 0
    ans = 0
    for (num in nums) {
      ans = max(ans, num * maxDiff)
      max = max(max, num)
      maxDiff = max(maxDiff, max - num)
    }
    return ans
  }
}
