internal class Solution {
  fun minNumber(nums1: IntArray, nums2: IntArray): Int {
    var ans = 100
    for (a in nums1) {
      for (b in nums2) {
        if (a == b) {
          ans = min(ans, a)
        } else {
          ans = min(ans, min(a * 10 + b, b * 10 + a))
        }
      }
    }
    return ans
  }
}
