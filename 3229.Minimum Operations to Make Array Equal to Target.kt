internal class Solution {
  fun minimumOperations(nums: IntArray, target: IntArray): Long {
    var f: Long = abs(target[0] - nums[0])
    for (i in 1 until nums.size) {
      val x = (target[i] - nums[i]).toLong()
      val y = (target[i - 1] - nums[i - 1]).toLong()
      if (x * y > 0) {
        val d: Long = abs(x) - abs(y)
        if (d > 0) {
          f += d
        }
      } else {
        f += abs(x)
      }
    }
    return f
  }
}
