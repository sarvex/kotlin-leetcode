import java.util.*

internal class Solution {
  fun addedInteger(nums1: IntArray?, nums2: IntArray?): Int {
    return Arrays.stream(nums2).min().asInt - Arrays.stream(nums1).min().asInt
  }
}
