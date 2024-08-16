internal class Solution {
  fun maximumUniqueSubarray(nums: IntArray): Int {
    val d = IntArray(10001)
    val n = nums.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans = 0
    var j = 0
    for (i in 1..n) {
      val v = nums[i - 1]
      j = max(j, d[v])
      ans = max(ans, s[i] - s[j])
      d[v] = i
    }
    return ans
  }
}
