import java.util.*

internal class Solution {
  fun minimumAddedCoins(coins: IntArray, target: Int): Int {
    Arrays.sort(coins)
    var ans = 0
    var i = 0
    var s = 1
    while (s <= target) {
      if (i < coins.size && coins[i] <= s) {
        s += coins[i++]
      } else {
        s = s shl 1
        ++ans
      }
    }
    return ans
  }
}
