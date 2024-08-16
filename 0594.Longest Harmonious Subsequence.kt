internal class Solution {
  fun findLHS(nums: IntArray): Int {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans = 0
    for (e in cnt.entrySet()) {
      val x: Int = e.getKey()
      val c: Int = e.getValue()
      if (cnt.containsKey(x + 1)) {
        ans = Math.max(ans, c + cnt[x + 1]!!)
      }
    }
    return ans
  }
}
