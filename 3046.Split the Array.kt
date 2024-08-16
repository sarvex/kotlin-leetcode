internal class Solution {
  fun isPossibleToSplit(nums: IntArray): Boolean {
    val cnt = IntArray(101)
    for (x in nums) {
      if (++cnt[x] >= 3) {
        return false
      }
    }
    return true
  }
}
