internal class Solution {
  fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    var ans = 0
    var i = 0
    var j = 0
    while (i < nums.size) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (cnt[nums[i]]!! > k) {
        cnt.merge(nums[j++], -1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
      ans = max(ans, i - j + 1)
      ++i
    }
    return ans
  }
}
