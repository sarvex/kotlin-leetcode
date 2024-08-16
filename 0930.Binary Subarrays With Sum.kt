internal class Solution {
  fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    val cnt = IntArray(nums.size + 1)
    cnt[0] = 1
    var ans = 0
    var s = 0
    for (v in nums) {
      s += v
      if (s - goal >= 0) {
        ans += cnt[s - goal]
      }
      ++cnt[s]
    }
    return ans
  }
}
