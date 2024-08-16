import java.util.*

internal class Solution {
  fun minimumRemoval(beans: IntArray): Long {
    Arrays.sort(beans)
    var s: Long = 0
    for (x in beans) {
      s += x.toLong()
    }
    var ans = s
    val n = beans.size
    for (i in 0 until n) {
      ans = min(ans, s - beans[i].toLong() * (n - i))
    }
    return ans
  }
}
