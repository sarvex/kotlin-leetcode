internal class Solution {
  fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
    val mod = 1e9.toInt() + 7
    Arrays.sort(horizontalCuts)
    Arrays.sort(verticalCuts)
    val m = horizontalCuts.size
    val n = verticalCuts.size
    var x: Long = max(horizontalCuts[0], h - horizontalCuts[m - 1])
    var y: Long = max(verticalCuts[0], w - verticalCuts[n - 1])
    for (i in 1 until m) {
      x = max(x, horizontalCuts[i] - horizontalCuts[i - 1])
    }
    for (i in 1 until n) {
      y = max(y, verticalCuts[i] - verticalCuts[i - 1])
    }
    return ((x * y) % mod).toInt()
  }
}
