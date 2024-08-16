import java.util.*

internal class Solution {
  fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    Arrays.sort(happiness)
    var ans: Long = 0
    var i = 0
    val n = happiness.size
    while (i < k) {
      val x = happiness[n - i - 1] - i
      ans += max(x, 0)
      ++i
    }
    return ans
  }
}
