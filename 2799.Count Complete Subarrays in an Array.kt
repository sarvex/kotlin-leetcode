internal class Solution {
  fun countCompleteSubarrays(nums: IntArray): Int {
    val s: Set<Int> = HashSet()
    for (x in nums) {
      s.add(x)
    }
    val cnt: Int = s.size()
    var ans = 0
    val n = nums.size
    for (i in 0 until n) {
      s.clear()
      for (j in i until n) {
        s.add(nums[j])
        if (s.size() === cnt) {
          ++ans
        }
      }
    }
    return ans
  }
}
