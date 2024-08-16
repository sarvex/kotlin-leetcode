internal class Solution {
  fun distMoney(money: Int, children: Int): Int {
    if (money < children) {
      return -1
    }
    if (money > 8 * children) {
      return children - 1
    }
    if (money == 8 * children - 4) {
      return children - 2
    }
    // money-8x >= children-x, x <= (money-children)/7
    return (money - children) / 7
  }
}
