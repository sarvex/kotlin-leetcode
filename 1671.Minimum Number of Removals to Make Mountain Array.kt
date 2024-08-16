internal class Solution {
  fun minimumMountainRemovals(nums: IntArray): Int {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    Arrays.fill(left, 1)
    Arrays.fill(right, 1)
    for (i in 1 until n) {
      for (j in 0 until i) {
        if (nums[i] > nums[j]) {
          left[i] = max(left[i], left[j] + 1)
        }
      }
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        if (nums[i] > nums[j]) {
          right[i] = max(right[i], right[j] + 1)
        }
      }
    }
    var ans = 0
    for (i in 0 until n) {
      if (left[i] > 1 && right[i] > 1) {
        ans = max(ans, left[i] + right[i] - 1)
      }
    }
    return n - ans
  }
}
