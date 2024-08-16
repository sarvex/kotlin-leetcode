internal class Solution {
  fun findIntersectionValues(nums1: IntArray, nums2: IntArray): IntArray {
    val s1 = IntArray(101)
    val s2 = IntArray(101)
    for (x in nums1) {
      s1[x] = 1
    }
    for (x in nums2) {
      s2[x] = 1
    }
    val ans = IntArray(2)
    for (x in nums1) {
      ans[0] += s2[x]
    }
    for (x in nums2) {
      ans[1] += s1[x]
    }
    return ans
  }
}
