internal class Solution {
  fun occurrencesOfElement(nums: IntArray, queries: IntArray, x: Int): IntArray {
    val ids: List<Int> = ArrayList()
    for (i in nums.indices) {
      if (nums[i] == x) {
        ids.add(i)
      }
    }
    val m = queries.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val j = queries[i] - 1
      ans[i] = if (j < ids.size()) ids[j] else -1
    }
    return ans
  }
}
