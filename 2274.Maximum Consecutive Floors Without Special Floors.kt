import java.util.*

internal class Solution {
  fun maxConsecutive(bottom: Int, top: Int, special: IntArray): Int {
    Arrays.sort(special)
    val n = special.size
    var ans: Int = max(special[0] - bottom, top - special[n - 1])
    for (i in 1 until n) {
      ans = max(ans, special[i] - special[i - 1] - 1)
    }
    return ans
  }
}
