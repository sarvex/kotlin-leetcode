internal class Solution {
  fun minOperations(nums: IntArray): Int {
    val n = nums.size
    Arrays.sort(nums)
    var m = 1
    for (i in 1 until n) {
      if (nums[i] != nums[i - 1]) {
        nums[m++] = nums[i]
      }
    }
    var ans = n
    for (i in 0 until m) {
      val j = search(nums, nums[i] + n - 1, i, m)
      ans = min(ans, n - (j - i))
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int, left: Int, right: Int): Int {
    var left = left
    var right = right
    while (left < right) {
      val mid = (left + right) shr 1
      if (nums[mid] > x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
