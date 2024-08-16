internal class Solution {
  fun nextPalindrome(num: String): String {
    val nums: CharArray = num.toCharArray()
    if (!nextPermutation(nums)) {
      return ""
    }
    val n = nums.size
    for (i in 0 until n / 2) {
      nums[n - 1 - i] = nums[i]
    }
    return String(nums)
  }

  private fun nextPermutation(nums: CharArray): Boolean {
    val n = nums.size / 2
    var i = n - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      --i
    }
    if (i < 0) {
      return false
    }
    var j = n - 1
    while (j >= 0 && nums[i] >= nums[j]) {
      --j
    }
    swap(nums, i++, j)
    j = n - 1
    while (i < j) {
      swap(nums, i, j)
      ++i
      --j
    }
    return true
  }

  private fun swap(nums: CharArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
