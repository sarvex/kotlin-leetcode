internal class Solution {
  fun minMoves(nums: IntArray, limit: Int): Int {
    val d = IntArray(2 * limit + 2)
    val n = nums.size
    for (i in 0 until n / 2) {
      val x: Int = min(nums[i], nums[n - i - 1])
      val y: Int = max(nums[i], nums[n - i - 1])
      d[2] += 2
      d[x + 1] -= 2
      d[x + 1] += 1
      d[x + y] -= 1
      d[x + y + 1] += 1
      d[y + limit + 1] -= 1
      d[y + limit + 1] += 2
    }
    var ans = n
    var i = 2
    var s = 0
    while (i < d.size) {
      s += d[i]
      ans = min(ans, s)
      ++i
    }
    return ans
  }
}
