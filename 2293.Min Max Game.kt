internal class Solution {
  fun minMaxGame(nums: IntArray): Int {
    var n = nums.size
    while (n > 1) {
      n = n shr 1
      for (i in 0 until n) {
        val a = nums[i shl 1]
        val b = nums[i shl 1 or 1]
        nums[i] = if (i % 2 == 0) min(a, b) else max(a, b)
      }
    }
    return nums[0]
  }
}
