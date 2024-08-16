internal class Solution {
  fun maximumSetSize(nums1: IntArray, nums2: IntArray): Int {
    val s1: Set<Int> = HashSet()
    val s2: Set<Int> = HashSet()
    for (x in nums1) {
      s1.add(x)
    }
    for (x in nums2) {
      s2.add(x)
    }
    val n = nums1.size
    var a = 0
    var b = 0
    var c = 0
    for (x in s1) {
      if (!s2.contains(x)) {
        ++a
      }
    }
    for (x in s2) {
      if (!s1.contains(x)) {
        ++b
      } else {
        ++c
      }
    }
    a = min(a, n / 2)
    b = min(b, n / 2)
    return min(a + b + c, n)
  }
}
