internal class Solution {
  fun accountBalanceAfterPurchase(purchaseAmount: Int): Int {
    var diff = 100
    var x = 0
    var y = 100
    while (y >= 0) {
      val t: Int = abs(y - purchaseAmount)
      if (t < diff) {
        diff = t
        x = y
      }
      y -= 10
    }
    return 100 - x
  }
}
