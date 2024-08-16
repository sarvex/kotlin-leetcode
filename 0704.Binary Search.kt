internal class Solution {
  fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
      val mid = (l + r) shr 1
      if (nums[mid] >= target) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return if (nums[l] == target) l else -1
  }
}
