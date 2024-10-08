internal class Solution {
  fun findPrefixScore(nums: IntArray): LongArray {
    val n = nums.size
    val ans = LongArray(n)
    var mx = 0
    for (i in 0 until n) {
      mx = max(mx, nums[i])
      ans[i] = nums[i] + mx + (if (i == 0) 0 else ans[i - 1])
    }
    return ans
  }
}
