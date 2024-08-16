internal class Solution {
  fun sumOfBeauties(nums: IntArray): Int {
    val n = nums.size
    val right = IntArray(n)
    right[n - 1] = nums[n - 1]
    for (i in n - 2 downTo 1) {
      right[i] = min(right[i + 1], nums[i])
    }
    var ans = 0
    var l = nums[0]
    for (i in 1 until n - 1) {
      val r = right[i + 1]
      if (l < nums[i] && nums[i] < r) {
        ans += 2
      } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
        ans += 1
      }
      l = max(l, nums[i])
    }
    return ans
  }
}
