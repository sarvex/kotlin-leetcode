internal class Solution {
  fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val cnt = IntArray(1001)
    for (x in nums1) {
      ++cnt[x]
    }
    val ans: List<Int> = ArrayList()
    for (x in nums2) {
      if (cnt[x]-- > 0) {
        ans.add(x)
      }
    }
    return ans.stream().mapToInt(Integer::intValue).toArray()
  }
}
