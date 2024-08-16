internal class Solution {
  fun maxSum(nums: List<Int>, m: Int, k: Int): Long {
    val cnt: Map<Int, Int> = HashMap()
    val n: Int = nums.size()
    var s: Long = 0
    for (i in 0 until k) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += nums[i]
    }
    var ans = if (cnt.size() >= m) s else 0
    for (i in k until n) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt.merge(nums[i - k], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(nums[i - k])
      }
      s += nums[i] - nums[i - k]
      if (cnt.size() >= m) {
        ans = max(ans, s)
      }
    }
    return ans
  }
}
