internal class Solution {
  fun arithmeticTriplets(nums: IntArray, diff: Int): Int {
    var ans = 0
    val n = nums.size
    for (i in 0 until n) {
      for (j in i + 1 until n) {
        for (k in j + 1 until n) {
          if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
            ++ans
          }
        }
      }
    }
    return ans
  }
}
