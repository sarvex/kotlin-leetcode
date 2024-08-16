internal class Solution {
  fun arrangeCoins(n: Int): Int {
    return (sqrt(2) * sqrt(n + 0.125) - 0.5).toInt()
  }
}
