internal class Solution {
  fun maximizeSum(nums: IntArray, k: Int): Int {
    var x = 0
    for (v in nums) {
      x = max(x, v)
    }
    return k * x + k * (k - 1) / 2
  }
}
