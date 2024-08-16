internal class Solution {
  fun pivotInteger(n: Int): Int {
    for (x in 1..n) {
      if ((1 + x) * x == (x + n) * (n - x + 1)) {
        return x
      }
    }
    return -1
  }
}
