internal class Solution {
  fun findMaxLength(nums: IntArray): Int {
    val d: Map<Int, Int> = HashMap()
    d.put(0, -1)
    var ans = 0
    var s = 0
    for (i in nums.indices) {
      s += if (nums[i] == 1) 1 else -1
      if (d.containsKey(s)) {
        ans = Math.max(ans, i - d[s])
      } else {
        d.put(s, i)
      }
    }
    return ans
  }
}
