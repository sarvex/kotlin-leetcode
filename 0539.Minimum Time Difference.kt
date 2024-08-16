internal class Solution {
  fun findMinDifference(timePoints: List<String>): Int {
    if (timePoints.size() > 1440) {
      return 0
    }
    val n: Int = timePoints.size()
    val nums = IntArray(n + 1)
    for (i in 0 until n) {
      val t: Array<String> = timePoints[i].split(":")
      nums[i] = t[0].toInt() * 60 + t[1].toInt()
    }
    Arrays.sort(nums, 0, n)
    nums[n] = nums[0] + 1440
    var ans = 1 shl 30
    for (i in 1..n) {
      ans = min(ans, nums[i] - nums[i - 1])
    }
    return ans
  }
}
