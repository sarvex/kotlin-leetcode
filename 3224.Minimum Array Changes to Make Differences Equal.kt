internal class Solution {
  fun minChanges(nums: IntArray, k: Int): Int {
    val d = IntArray(k + 2)
    val n = nums.size
    for (i in 0 until n / 2) {
      val x: Int = min(nums[i], nums[n - i - 1])
      val y: Int = max(nums[i], nums[n - i - 1])
      d[0] += 1
      d[y - x] -= 1
      d[y - x + 1] += 1
      d[max(y, k - x) + 1] -= 1
      d[max(y, k - x) + 1] += 2
    }
    var ans = n
    var s = 0
    for (x in d) {
      s += x
      ans = min(ans, s)
    }
    return ans
  }
}
