internal class Solution {
  fun minOperations(nums1: IntArray, nums2: IntArray): Int {
    val s1: Int = Arrays.stream(nums1).sum()
    val s2: Int = Arrays.stream(nums2).sum()
    if (s1 == s2) {
      return 0
    }
    if (s1 > s2) {
      return minOperations(nums2, nums1)
    }
    var d = s2 - s1
    val arr = IntArray(nums1.size + nums2.size)
    var k = 0
    for (v in nums1) {
      arr[k++] = 6 - v
    }
    for (v in nums2) {
      arr[k++] = v - 1
    }
    Arrays.sort(arr)
    var i = 1
    var j = arr.size - 1
    while (j >= 0) {
      d -= arr[j]
      if (d <= 0) {
        return i
      }
      ++i
      --j
    }
    return -1
  }
}
