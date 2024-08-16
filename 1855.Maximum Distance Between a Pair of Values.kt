internal class Solution {
  fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
    var ans = 0
    val m = nums1.size
    val n = nums2.size
    for (i in 0 until m) {
      var left: Int = i
      var right = n - 1
      while (left < right) {
        val mid = (left + right + 1) shr 1
        if (nums2[mid] >= nums1[i]) {
          left = mid
        } else {
          right = mid - 1
        }
      }
      ans = max(ans, left - i)
    }
    return ans
  }
}
