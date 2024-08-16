internal class Solution {
  fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    val arr = nums.clone()
    Arrays.sort(arr)
    for (i in nums.indices) {
      nums[i] = search(arr, nums[i])
    }
    return nums
  }

  private fun search(nums: IntArray, x: Int): Int {
    var l = 0
    var r = nums.size
    while (l < r) {
      val mid = (l + r) shr 1
      if (nums[mid] >= x) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }
}
