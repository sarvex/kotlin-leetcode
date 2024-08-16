internal class Solution {
  private var nums: IntArray
  private var k = 0

  fun findKthLargest(nums: IntArray, k: Int): Int {
    this.nums = nums
    this.k = nums.size - k
    return quickSort(0, nums.size - 1)
  }

  private fun quickSort(l: Int, r: Int): Int {
    if (l == r) {
      return nums[l]
    }
    var i = l - 1
    var j = r + 1
    val x = nums[(l + r) ushr 1]
    while (i < j) {
      while (nums[++i] < x) {
      }
      while (nums[--j] > x) {
      }
      if (i < j) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
      }
    }
    if (j < k) {
      return quickSort(j + 1, r)
    }
    return quickSort(l, j)
  }
}
