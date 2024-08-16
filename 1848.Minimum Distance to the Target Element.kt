internal class Solution {
  fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
    val n = nums.size
    var ans = n
    for (i in 0 until n) {
      if (nums[i] == target) {
        ans = min(ans, abs(i - start))
      }
    }
    return ans
  }
}
