internal class Solution {
  fun arrayChange(nums: IntArray, operations: Array<IntArray>): IntArray {
    val n = nums.size
    val d: Map<Int, Int> = HashMap(n)
    for (i in 0 until n) {
      d.put(nums[i], i)
    }
    for (op in operations) {
      val x = op[0]
      val y = op[1]
      nums[d[x]!!] = y
      d.put(y, d[x])
    }
    return nums
  }
}
