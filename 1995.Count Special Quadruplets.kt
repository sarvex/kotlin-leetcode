internal class Solution {
  fun countQuadruplets(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    for (a in 0 until n - 3) {
      for (b in a + 1 until n - 2) {
        for (c in b + 1 until n - 1) {
          for (d in c + 1 until n) {
            if (nums[a] + nums[b] + nums[c] == nums[d]) {
              ++ans
            }
          }
        }
      }
    }
    return ans
  }
}
