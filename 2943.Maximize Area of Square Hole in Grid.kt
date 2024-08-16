import java.util.*

internal class Solution {
  fun maximizeSquareHoleArea(n: Int, m: Int, hBars: IntArray, vBars: IntArray): Int {
    val x: Int = min(f(hBars), f(vBars))
    return x * x
  }

  private fun f(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 1
    var cnt = 1
    for (i in 1 until nums.size) {
      if (nums[i] == nums[i - 1] + 1) {
        ans = max(ans, ++cnt)
      } else {
        cnt = 1
      }
    }
    return ans + 1
  }
}
