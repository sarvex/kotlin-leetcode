internal class Solution {
  fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    val p: Map<Int, Long> = HashMap()
    p.put(nums[0], 0L)
    var s: Long = 0
    val n = nums.size
    var ans: Long = MIN_VALUE
    for (i in 0 until n) {
      s += nums[i].toLong()
      if (p.containsKey(nums[i] - k)) {
        ans = Math.max(ans, s - p[nums[i] - k]!!)
      }
      if (p.containsKey(nums[i] + k)) {
        ans = Math.max(ans, s - p[nums[i] + k]!!)
      }
      if (i + 1 < n && (!p.containsKey(nums[i + 1]) || p[nums[i + 1]]!! > s)) {
        p.put(nums[i + 1], s)
      }
    }
    return if (ans == MIN_VALUE) 0 else ans
  }
}
