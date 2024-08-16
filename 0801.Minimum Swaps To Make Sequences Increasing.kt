internal class Solution {
  fun minSwap(nums1: IntArray, nums2: IntArray): Int {
    var a = 0
    var b = 1
    for (i in 1 until nums1.size) {
      val x = a
      val y = b
      if (nums1[i - 1] >= nums1[i] || nums2[i - 1] >= nums2[i]) {
        a = y
        b = x + 1
      } else {
        b = y + 1
        if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
          a = min(a, y)
          b = min(b, x + 1)
        }
      }
    }
    return min(a, b)
  }
}
