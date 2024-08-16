internal class Solution {
  fun numOfPairs(nums: Array<String>, target: String): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (i != j && target == nums[i] + nums[j]) {
          ++ans
        }
      }
    }
    return ans
  }
}
