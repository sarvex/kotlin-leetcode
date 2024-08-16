internal class Solution {
  fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
    var ans = 0
    var prev = 0
    for (e in brackets) {
      val upper = e[0]
      val percent = e[1]
      ans += max(0, min(income, upper) - prev) * percent
      prev = upper
    }
    return ans / 100.0
  }
}
