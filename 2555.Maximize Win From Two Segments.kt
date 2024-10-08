internal class Solution {
  fun maximizeWin(prizePositions: IntArray, k: Int): Int {
    val n = prizePositions.size
    val f = IntArray(n + 1)
    var ans = 0
    for (i in 1..n) {
      val x = prizePositions[i - 1]
      val j = search(prizePositions, x - k)
      ans = max(ans, f[j] + i - j)
      f[i] = max(f[i - 1], i - j)
    }
    return ans
  }

  private fun search(nums: IntArray, x: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
      val mid = (left + right) shr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
