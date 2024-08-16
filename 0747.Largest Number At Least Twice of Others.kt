internal class Solution {
  fun dominantIndex(nums: IntArray): Int {
    val n = nums.size
    var k = 0
    for (i in 0 until n) {
      if (nums[k] < nums[i]) {
        k = i
      }
    }
    for (i in 0 until n) {
      if (k != i && nums[k] < nums[i] * 2) {
        return -1
      }
    }
    return k
  }
}
