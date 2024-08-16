import java.util.*

internal class Solution {
  fun minMoves(rooks: Array<IntArray>): Int {
    Arrays.sort(rooks) { a, b -> a[0] - b[0] }
    var ans = 0
    val n = rooks.size
    for (i in 0 until n) {
      ans += abs(rooks[i][0] - i)
    }
    Arrays.sort(rooks) { a, b -> a[1] - b[1] }
    for (j in 0 until n) {
      ans += abs(rooks[j][1] - j)
    }
    return ans
  }
}
