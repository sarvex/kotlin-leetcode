import java.util.*

internal class Solution {
  fun countDays(days: Int, meetings: Array<IntArray>): Int {
    Arrays.sort(meetings) { a, b -> a[0] - b[0] }
    var ans = 0
    var last = 0
    for (e in meetings) {
      val st = e[0]
      val ed = e[1]
      if (last < st) {
        ans += st - last - 1
      }
      last = max(last, ed)
    }
    ans += days - last
    return ans
  }
}
