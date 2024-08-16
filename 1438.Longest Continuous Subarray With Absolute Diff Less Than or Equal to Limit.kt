internal class Solution {
  fun longestSubarray(nums: IntArray, limit: Int): Int {
    val tm: TreeMap<Int, Int> = TreeMap()
    var ans = 0
    var i = 0
    var j = 0
    while (i < nums.size) {
      tm.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      while (tm.lastKey() - tm.firstKey() > limit) {
        if (tm.merge(nums[j], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
          tm.remove(nums[j])
        }
        ++j
      }
      ans = max(ans, i - j + 1)
      ++i
    }
    return ans
  }
}
