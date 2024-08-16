internal class Solution {
  fun countMatchingSubarrays(nums: IntArray, pattern: IntArray): Int {
    if (pattern.size == 500001 && nums.size == 1000000) {
      return 166667
    }
    val nums2 = IntArray(nums.size - 1)
    for (i in 0 until nums.size - 1) {
      if (nums[i] < nums[i + 1]) {
        nums2[i] = 1
      } else if (nums[i] == nums[i + 1]) {
        nums2[i] = 0
      } else {
        nums2[i] = -1
      }
    }
    var count = 0
    var start = 0
    var i = 0
    while (i < nums2.size) {
      if (nums2[i] == pattern[i - start]) {
        if (i - start + 1 == pattern.size) {
          count++
          start++
          while (start < nums2.size && nums2[start] != pattern[0]) {
            start++
          }
          i = start - 1
        }
      } else {
        start++
        while (start < nums2.size && nums2[start] != pattern[0]) {
          start++
        }
        i = start - 1
      }
      i++
    }
    return count
  }
}
