internal class Solution {
  fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
    var ans = IntArray(3)
    var s = 0
    var s1 = 0
    var s2 = 0
    var s3 = 0
    var mx1 = 0
    var mx12 = 0
    var idx1 = 0
    var idx121 = 0
    var idx122 = 0
    for (i in k * 2 until nums.size) {
      s1 += nums[i - k * 2]
      s2 += nums[i - k]
      s3 += nums[i]
      if (i >= k * 3 - 1) {
        if (s1 > mx1) {
          mx1 = s1
          idx1 = i - k * 3 + 1
        }
        if (mx1 + s2 > mx12) {
          mx12 = mx1 + s2
          idx121 = idx1
          idx122 = i - k * 2 + 1
        }
        if (mx12 + s3 > s) {
          s = mx12 + s3
          ans = intArrayOf(idx121, idx122, i - k + 1)
        }
        s1 -= nums[i - k * 3 + 1]
        s2 -= nums[i - k * 2 + 1]
        s3 -= nums[i - k + 1]
      }
    }
    return ans
  }
}
