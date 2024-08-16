internal class Solution {
  fun twoSumLessThanK(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = -1
    val n = nums.size
    for (i in 0 until n) {
      val j = search(nums, k - nums[i], i + 1, n) - 1
      if (i < j) {
        ans = max(ans, nums[i] + nums[j])
      }
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int, l: Int, r: Int): Int {
    var l = l
    var r = r
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
