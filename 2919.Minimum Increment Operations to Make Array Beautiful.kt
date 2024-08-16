internal class Solution {
  fun minIncrementOperations(nums: IntArray, k: Int): Long {
    var f: Long = 0
    var g: Long = 0
    var h: Long = 0
    for (x in nums) {
      val hh: Long = min(min(f, g), h) + max(k - x, 0)
      f = g
      g = h
      h = hh
    }
    return min(min(f, g), h)
  }
}
