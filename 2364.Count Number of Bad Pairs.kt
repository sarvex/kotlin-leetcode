internal class Solution {
  fun countBadPairs(nums: IntArray): Long {
    val cnt: Map<Int, Int> = HashMap()
    var ans: Long = 0
    for (i in nums.indices) {
      val x: Int = i - nums[i]
      ans += i - cnt.getOrDefault(x, 0)
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    return ans
  }
}
