internal class Solution {
  fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val n = nums.size
    val s = BooleanArray(n + 1)
    for (x in nums) {
      s[x] = true
    }
    val ans: List<Int> = ArrayList()
    for (i in 1..n) {
      if (!s[i]) {
        ans.add(i)
      }
    }
    return ans
  }
}
