import java.util.*

internal class Solution {
  fun fillCups(amount: IntArray): Int {
    var ans = 0
    while (amount[0] + amount[1] + amount[2] > 0) {
      Arrays.sort(amount)
      ++ans
      amount[2]--
      amount[1] = max(0, amount[1] - 1)
    }
    return ans
  }
}
