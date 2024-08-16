internal class Solution {
  fun partitionDisjoint(nums: IntArray): Int {
    val n = nums.size
    val mi = IntArray(n + 1)
    mi[n] = nums[n - 1]
    for (i in n - 1 downTo 0) {
      mi[i] = min(nums[i], mi[i + 1])
    }
    var mx = 0
    var i = 1
    while (true) {
      val v = nums[i - 1]
      mx = max(mx, v)
      if (mx <= mi[i]) {
        return i
      }
      ++i
    }
  }
}
