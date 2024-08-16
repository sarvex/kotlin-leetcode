internal class Solution {
  fun countSubarrays(nums: IntArray, k: Int): Long {
    var ans: Long = 0
    var pre: Map<Int, Int?> = HashMap()
    for (x in nums) {
      val cur: Map<Int, Int> = HashMap()
      for (e in pre.entrySet()) {
        val y: Int = e.getKey()
        val v: Int = e.getValue()
        cur.merge(x and y, v) { a: Int, b: Int -> Integer.sum(a, b) }
      }
      cur.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      ans += cur.getOrDefault(k, 0)
      pre = cur
    }
    return ans
  }
}
