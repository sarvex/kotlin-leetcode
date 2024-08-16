internal class Solution {
  fun minAbsoluteSumDiff(nums1: IntArray, nums2: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val nums = nums1.clone()
    Arrays.sort(nums)
    var s = 0
    val n = nums.size
    for (i in 0 until n) {
      s = (s + abs(nums1[i] - nums2[i])) % mod
    }
    var mx = 0
    for (i in 0 until n) {
      val d1: Int = abs(nums1[i] - nums2[i])
      var d2 = 1 shl 30
      val j = search(nums, nums2[i])
      if (j < n) {
        d2 = min(d2, abs(nums[j] - nums2[i]))
      }
      if (j > 0) {
        d2 = min(d2, abs(nums[j - 1] - nums2[i]))
      }
      mx = max(mx, d1 - d2)
    }
    return (s - mx + mod) % mod
  }

  private fun search(nums: IntArray, x: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
      val mid = (left + right) ushr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
