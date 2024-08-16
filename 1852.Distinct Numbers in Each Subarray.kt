internal class Solution {
  fun distinctNumbers(nums: IntArray, k: Int): IntArray {
    val cnt: Map<Int, Int> = HashMap()
    for (i in 0 until k) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val n = nums.size
    val ans = IntArray(n - k + 1)
    ans[0] = cnt.size()
    for (i in k until n) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt.merge(nums[i - k], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(nums[i - k])
      }
      ans[i - k + 1] = cnt.size()
    }
    return ans
  }
}
