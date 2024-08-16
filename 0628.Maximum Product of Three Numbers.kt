internal class Solution {
  fun maximumProduct(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    val a = nums[n - 1] * nums[n - 2] * nums[n - 3]
    val b = nums[n - 1] * nums[0] * nums[1]
    return max(a, b)
  }
}
