internal class Solution {
  fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
    var numBottles = numBottles
    var numExchange = numExchange
    var ans = numBottles
    while (numBottles >= numExchange) {
      numBottles -= numExchange
      ++numExchange
      ++ans
      ++numBottles
    }
    return ans
  }
}
