internal class Solution {
  fun minimumOperations(nums: List<Int>): Int {
    var f = IntArray(3)
    for (x in nums) {
      val g = IntArray(3)
      if (x == 1) {
        g[0] = f[0]
        g[1] = min(f[0], f[1]) + 1
        g[2] = min(f[0], min(f[1], f[2])) + 1
      } else if (x == 2) {
        g[0] = f[0] + 1
        g[1] = min(f[0], f[1])
        g[2] = min(f[0], min(f[1], f[2])) + 1
      } else {
        g[0] = f[0] + 1
        g[1] = min(f[0], f[1]) + 1
        g[2] = min(f[0], min(f[1], f[2]))
      }
      f = g
    }
    return min(f[0], min(f[1], f[2]))
  }
}
