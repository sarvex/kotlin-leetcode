internal class Solution {
  fun minOperations(nums: IntArray): Int {
    val g: List<Int> = ArrayList()
    for (x in nums) {
      var l = 0
      var r: Int = g.size()
      while (l < r) {
        val mid = (l + r) shr 1
        if (g[mid] < x) {
          r = mid
        } else {
          l = mid + 1
        }
      }
      if (l == g.size()) {
        g.add(x)
      } else {
        g.set(l, x)
      }
    }
    return g.size()
  }
}
