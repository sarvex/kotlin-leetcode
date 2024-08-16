internal class Solution {
  fun unequalTriplets(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        for (k in j + 1 until n) {
          if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
            ++ans
          }
        }
      }
    }
    return ans
  }
}
