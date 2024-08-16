internal class Solution {
  fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
    val n = nums.size
    val d = IntArray(n)
    for (i in 1 until n) {
      if (nums[i] % 2 != nums[i - 1] % 2) {
        d[i] = d[i - 1]
      } else {
        d[i] = i
      }
    }
    val m = queries.size
    val ans = BooleanArray(m)
    for (i in 0 until m) {
      ans[i] = d[queries[i][1]] <= queries[i][0]
    }
    return ans
  }
}
