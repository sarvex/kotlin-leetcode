internal class Solution {
  fun minStartValue(nums: IntArray): Int {
    var s = 0
    var t: Int = MAX_VALUE
    for (num in nums) {
      s += num
      t = min(t, s)
    }
    return max(1, 1 - t)
  }
}
