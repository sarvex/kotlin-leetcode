internal class Solution {
  fun isGood(nums: IntArray): Boolean {
    val n = nums.size - 1
    val cnt = IntArray(201)
    for (x in nums) {
      ++cnt[x]
    }
    if (cnt[n] != 2) {
      return false
    }
    for (i in 1 until n) {
      if (cnt[i] != 1) {
        return false
      }
    }
    return true
  }
}
