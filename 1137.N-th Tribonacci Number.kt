internal class Solution {
  fun tribonacci(n: Int): Int {
    var n = n
    var a = 0
    var b = 1
    var c = 1
    while (n-- > 0) {
      val d = a + b + c
      a = b
      b = c
      c = d
    }
    return a
  }
}
