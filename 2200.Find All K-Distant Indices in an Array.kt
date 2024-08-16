internal class Solution {
  fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
    val n = nums.size
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      for (j in 0 until n) {
        if (abs(i - j) <= k && nums[j] == key) {
          ans.add(i)
          break
        }
      }
    }
    return ans
  }
}
