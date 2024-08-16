import java.util.*

internal class Solution {
  fun shortestSubstrings(arr: Array<String>): Array<String> {
    val n = arr.size
    val ans: Array<String> = arrayOfNulls(n)
    Arrays.fill(ans, "")
    for (i in 0 until n) {
      val m = arr[i].length
      var j = 1
      while (j <= m && ans[i].isEmpty()) {
        for (l in 0..(m - j)) {
          val sub: String = arr[i].substring(l, l + j)
          if (ans[i].isEmpty() || sub.compareTo(ans[i]) < 0) {
            var ok = true
            var k = 0
            while (k < n && ok) {
              if (k != i && arr[k].contains(sub)) {
                ok = false
              }
              ++k
            }
            if (ok) {
              ans[i] = sub
            }
          }
        }
        ++j
      }
    }
    return ans
  }
}
