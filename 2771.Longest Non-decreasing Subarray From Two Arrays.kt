internal class Solution {
  fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    var f = 1
    var g = 1
    var ans = 1
    for (i in 1 until n) {
      var ff = 1
      var gg = 1
      if (nums1[i] >= nums1[i - 1]) {
        ff = max(ff, f + 1)
      }
      if (nums1[i] >= nums2[i - 1]) {
        ff = max(ff, g + 1)
      }
      if (nums2[i] >= nums1[i - 1]) {
        gg = max(gg, f + 1)
      }
      if (nums2[i] >= nums2[i - 1]) {
        gg = max(gg, g + 1)
      }
      f = ff
      g = gg
      ans = max(ans, max(f, g))
    }
    return ans
  }
}
