internal class Solution {
  fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val d: Map<Int, Int> = HashMap()
    d.put(0, -1)
    var s = 0
    for (i in nums.indices) {
      s = (s + nums[i]) % k
      if (!d.containsKey(s)) {
        d.put(s, i)
      } else if (i - d[s] > 1) {
        return true
      }
    }
    return false
  }
}
