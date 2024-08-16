internal class Solution {
  fun minKBitFlips(nums: IntArray, k: Int): Int {
    val n = nums.size
    val d = IntArray(n + 1)
    var ans = 0
    var s = 0
    for (i in 0 until n) {
      s += d[i]
      if (s % 2 == nums[i]) {
        if (i + k > n) {
          return -1
        }
        ++d[i]
        --d[i + k]
        ++s
        ++ans
      }
    }
    return ans
  }
}
