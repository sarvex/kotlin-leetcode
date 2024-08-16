internal class Solution {
  fun findLonely(nums: IntArray): List<Int> {
    val cnt: Map<Int, Int> = HashMap()
    for (x in nums) {
      cnt.merge(x, 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    val ans: List<Int> = ArrayList()
    for (e in cnt.entrySet()) {
      val x: Int = e.getKey()
      val v: Int = e.getValue()
      if (v == 1 && !cnt.containsKey(x - 1) && !cnt.containsKey(x + 1)) {
        ans.add(x)
      }
    }
    return ans
  }
}
