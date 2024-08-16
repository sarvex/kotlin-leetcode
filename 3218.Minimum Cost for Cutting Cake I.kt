import java.util.*

internal class Solution {
  fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Int {
    Arrays.sort(horizontalCut)
    Arrays.sort(verticalCut)
    var ans = 0
    var i = m - 2
    var j = n - 2
    var h = 1
    var v = 1
    while (i >= 0 || j >= 0) {
      if (j < 0 || (i >= 0 && horizontalCut[i] > verticalCut[j])) {
        ans += horizontalCut[i--] * v
        ++h
      } else {
        ans += verticalCut[j--] * h
        ++v
      }
    }
    return ans
  }
}
