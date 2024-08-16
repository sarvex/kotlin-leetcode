internal class Solution {
  fun searchInsert(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = (l + r) ushr 1
      if (nums[mid] >= target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
