internal class Solution {
  fun minimumCost(nums: IntArray): Int {
    val a = nums[0]
    var b = 100
    var c = 100
    for (i in 1 until nums.size) {
      if (nums[i] < b) {
        c = b
        b = nums[i]
      } else if (nums[i] < c) {
        c = nums[i]
      }
    }
    return a + b + c
  }
}
