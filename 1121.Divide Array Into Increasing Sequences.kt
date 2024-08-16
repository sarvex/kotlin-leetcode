internal class Solution {
  fun canDivideIntoSubsequences(nums: IntArray, k: Int): Boolean {
    val cnt: Map<Int, Int> = HashMap()
    var mx = 0
    for (x in nums) {
      mx = Math.max(mx, cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) })
    }
    return mx * k <= nums.size
  }
}
