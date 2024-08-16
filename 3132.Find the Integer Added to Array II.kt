import java.util.*

internal class Solution {
  fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
    Arrays.sort(nums1)
    Arrays.sort(nums2)
    var ans = 1 shl 30
    for (i in 0..2) {
      val x = nums2[0] - nums1[i]
      if (f(nums1, nums2, x)) {
        ans = min(ans, x)
      }
    }
    return ans
  }

  private fun f(nums1: IntArray, nums2: IntArray, x: Int): Boolean {
    var i = 0
    var j = 0
    var cnt = 0
    while (i < nums1.size && j < nums2.size) {
      if (nums2[j] - nums1[i] != x) {
        ++cnt
      } else {
        ++j
      }
      ++i
    }
    return cnt <= 2
  }
}
