internal class Solution {
  private var nums: IntArray
  private var t: IntArray

  fun reversePairs(nums: IntArray): Int {
    this.nums = nums
    val n = nums.size
    this.t = IntArray(n)
    return mergeSort(0, n - 1)
  }

  private fun mergeSort(l: Int, r: Int): Int {
    if (l >= r) {
      return 0
    }
    val mid = (l + r) shr 1
    var ans = mergeSort(l, mid) + mergeSort(mid + 1, r)
    var i = l
    var j = mid + 1
    var k = 0
    while (i <= mid && j <= r) {
      if (nums[i] <= nums[j] * 2L) {
        ++i
      } else {
        ans += mid - i + 1
        ++j
      }
    }
    i = l
    j = mid + 1
    while (i <= mid && j <= r) {
      if (nums[i] <= nums[j]) {
        t[k++] = nums[i++]
      } else {
        t[k++] = nums[j++]
      }
    }
    while (i <= mid) {
      t[k++] = nums[i++]
    }
    while (j <= r) {
      t[k++] = nums[j++]
    }
    i = l
    while (i <= r) {
      nums[i] = t[i - l]
      ++i
    }
    return ans
  }
}
