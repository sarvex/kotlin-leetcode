import java.util.*

internal class Solution {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val d: Map<Int, Int> = HashMap()
    var i = 0
    while (true) {
      val x = nums[i]
      val y = target - x
      if (d.containsKey(y)) {
        return intArrayOf(d[y]!!, i)
      }
      d.put(x, i)
      ++i
    }
  }
}
