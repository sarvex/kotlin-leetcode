internal class Solution {
  fun minimumAverageDifference(nums: IntArray): Int {
    val n = nums.size
    var pre: Long = 0
    var suf: Long = 0
    for (x in nums) {
      suf += x.toLong()
    }
    var ans = 0
    var mi: Long = MAX_VALUE
    for (i in 0 until n) {
      pre += nums[i].toLong()
      suf -= nums[i].toLong()
      val a: Long = pre / (i + 1)
      val b: Long = if (n - i - 1 == 0) 0 else suf / (n - i - 1)
      val t: Long = abs(a - b)
      if (t < mi) {
        ans = i
        mi = t
      }
    }
    return ans
  }
}
